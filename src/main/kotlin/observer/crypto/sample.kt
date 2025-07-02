package observer.crypto

import observer.crypto.data.CryptoData
import observer.crypto.observers.TabrizCryptoMonitor
import observer.crypto.observers.TehranCryptoMonitor
import observer.crypto.observers.HormozCryptoMonitor


fun main(){

    val cryptoData = CryptoData()

    val tehranCryptoMonitor = TehranCryptoMonitor(cryptoData)
    val tabrizCryptoMonitor = TabrizCryptoMonitor(cryptoData)
    val hormozCryptoMonitor = HormozCryptoMonitor(cryptoData)

    cryptoData.updateAmounts(82200f,7.6399995E9F)


    cryptoData.removeCryptoObserver(tabrizCryptoMonitor)
    cryptoData.removeCryptoObserver(hormozCryptoMonitor)


    cryptoData.updateAmounts(93000f, 9.6399995E9F)


}