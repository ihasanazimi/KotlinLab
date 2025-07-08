package observer_pattern.crypto.observers

import observer_pattern.crypto.data.CryptoData
import observer_pattern.crypto.data.CryptoDisplayElement
import observer_pattern.crypto.data.CryptoObserver

class TehranCryptoMonitor(private val cryptoData: CryptoData) : CryptoObserver , CryptoDisplayElement {

    var usdtIRTAmount : Float = 0f
    var btcIRTAmount : Float = 0f


    init {
        cryptoData.registerCryptoObserver(this)
    }

    override fun updateAmount() {
        this.usdtIRTAmount = cryptoData.getUsdtIrtAmount()
        this.btcIRTAmount = cryptoData.getBtcIrtAmount()
        displayAmounts()
    }

    override fun displayAmounts() {
        println(this::class.java.simpleName + "         USDT amount is  -> $usdtIRTAmount TOMAN            BTC amount is  ->  $btcIRTAmount TOMAN" + "\n")
    }


}