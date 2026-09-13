package com.kachat.app.util

/**
 * Transparent service fee for paid on-chain KaChat transfers.
 *
 * 0.10% == 10 basis points == 0.001 = 10 / 10_000.
 * All calculations use integer sompi precision only.
 */
object ServiceFeeCalculator {
    const val SERVICE_FEE_BASIS_POINTS = 10L
    const val SERVICE_FEE_BASIS_POINTS_DENOMINATOR = 10_000L
    const val SERVICE_FEE_ADDRESS = "kaspa:qr8p8pxr50twaud0hk8lv7c33qvte6lpyp05pzh8ngf74t9qh95x6ezuf00fn"

    fun appliesToPaidOnChainTransaction(amountSompi: Long): Boolean = amountSompi > 0L

    fun calculateServiceFeeSompi(amountSompi: Long): Long {
        if (!appliesToPaidOnChainTransaction(amountSompi)) return 0L
        return (amountSompi * SERVICE_FEE_BASIS_POINTS) / SERVICE_FEE_BASIS_POINTS_DENOMINATOR
    }
}
