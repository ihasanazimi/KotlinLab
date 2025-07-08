package observer_pattern.crypto

import observer_pattern.crypto.data.CryptoData
import observer_pattern.crypto.observers.TabrizCryptoMonitor
import observer_pattern.crypto.observers.TehranCryptoMonitor
import observer_pattern.crypto.observers.HormozCryptoMonitor


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