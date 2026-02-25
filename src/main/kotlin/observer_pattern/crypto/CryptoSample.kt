package observer_pattern.crypto



interface CryptoObserver {
    fun updateAmount()
}

interface CryptoSubject {
    fun registerCryptoObserver(o : CryptoObserver)
    fun removeCryptoObserver(o : CryptoObserver)
    fun notifyCryptoObserver()
}


interface CryptoDisplayElement{
    fun displayAmounts()
}



/******************************************************************/



class CryptoData : CryptoSubject{

    private val observersList = arrayListOf<CryptoObserver>()
    private var usdtIrtAmount = 0f
    private var btcIrtAmount = 0f

    init {
        /* use can initial some observer in the int block */
    }

    override fun registerCryptoObserver(o: CryptoObserver) {
        observersList.add(o)
    }

    override fun removeCryptoObserver(o: CryptoObserver) {
        observersList.remove(o)
    }

    override fun notifyCryptoObserver() {
        for (o in observersList){
            o.updateAmount()
        }
    }


    fun pushUpdateAmounts(usdtIrt : Float, btcIrt : Float){
        this.usdtIrtAmount = usdtIrt
        this.btcIrtAmount = btcIrt
        notifyCryptoObserver()
    }

    fun getUsdtIrtAmount() = usdtIrtAmount
    fun getBtcIrtAmount() = btcIrtAmount

}



/*---------------------------------------------------------------------------------------------------------------------*/

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


/*---------------------------------------------------------------------------------------------------------------------*/


class TabrizCryptoMonitor(private val cryptoData: CryptoData) : CryptoObserver , CryptoDisplayElement {

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

/*---------------------------------------------------------------------------------------------------------------------*/



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


/*---------------------------------------------------------------------------------------------------------------------*/


fun main(){

    val cryptoData = CryptoData()

    val tehranCryptoMonitor = TehranCryptoMonitor(cryptoData)
    val tabrizCryptoMonitor = TabrizCryptoMonitor(cryptoData)
    val hormozCryptoMonitor = HormozCryptoMonitor(cryptoData)

    cryptoData.pushUpdateAmounts(82200f,7.6399995E9F)


    cryptoData.removeCryptoObserver(tabrizCryptoMonitor)
    cryptoData.removeCryptoObserver(hormozCryptoMonitor)


    cryptoData.pushUpdateAmounts(93000f, 9.6399995E9F)


}