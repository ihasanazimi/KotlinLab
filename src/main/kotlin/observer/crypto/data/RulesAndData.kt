package observer.crypto.data



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