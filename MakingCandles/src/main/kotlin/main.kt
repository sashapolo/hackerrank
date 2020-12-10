import java.math.BigInteger

val TWO: BigInteger = BigInteger.valueOf(2)

fun minimumPasses(m: Long, w: Long, p: Long, n: Long): Long {
    val bigIntN = n.toBigInteger()
    val bigIntP = p.toBigInteger()

    var curM = m.toBigInteger()
    var curW = w.toBigInteger()
    var curTurn = BigInteger.ZERO
    var producedCandies = BigInteger.ZERO
    var result: BigInteger? = null
    while (true) {
        val productionPerTurn = curM * curW

        // compute how long it will take if we do not buy anything
        val predictedTurns = curTurn + ((bigIntN - producedCandies) ceilDivide productionPerTurn)
        result = if (result == null) predictedTurns else result.min(predictedTurns)

        val turnsToAccumulate = (bigIntP - producedCandies) ceilDivide productionPerTurn
        curTurn += turnsToAccumulate
        producedCandies += turnsToAccumulate * productionPerTurn

        if (producedCandies >= bigIntN) {
            break
        }

        // buy as much stuff as we can, trying to keep number of workers and machines equal
        var canBuy = producedCandies / bigIntP
        producedCandies %= bigIntP
        // first buy stuff to equalize the number of machines and workers
        val mwDiff = (curM - curW).abs().min(canBuy)
        if (curM > curW) {
            curW += mwDiff
        } else {
            curM += mwDiff
        }
        // then buy everything in equal proportions
        canBuy -= mwDiff
        curM += canBuy / TWO
        curW += canBuy ceilDivide TWO
    }
    return result?.toLong() ?: 1
}

infix fun BigInteger.ceilDivide(b: BigInteger): BigInteger = (this + b - BigInteger.ONE) / b

fun main() {
    val (m, w, p, n) = readLine()!!.split(" ").map { it.trim().toLong() }
    val result = minimumPasses(m, w, p, n)

    println(result)
}
