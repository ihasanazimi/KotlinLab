package observer.crypto.observers

import observer.crypto.data.CryptoData
import observer.crypto.data.CryptoDisplayElement
import observer.crypto.data.CryptoObserver

class HormozCryptoMonitor(private val cryptoData: CryptoData) : CryptoObserver , CryptoDisplayElement {

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