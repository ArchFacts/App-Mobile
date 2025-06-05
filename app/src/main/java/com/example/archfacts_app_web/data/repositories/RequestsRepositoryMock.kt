package com.example.archfacts_app_web.data.repositories

import com.example.archfacts_app_web.components.CardType
import com.example.archfacts_app_web.enums.RequestEnum
import com.example.archfacts_app_web.screens.RequestData

class RequestsRepositoryMock {
    fun getRequests(type: CardType): List<RequestData> {
        return listOf(
            RequestData(
                title = "Validar cores",
                dateEnd = "28 Mar, 10:29",
                status = RequestEnum.FINALIZADO,
                type = type
            ),
            RequestData(
                title = "Corrigir bug UI",
                dateEnd = "29 Mar, 14:30",
                status = RequestEnum.EM_PROGRESSO,
                type = type
            )
            // ...adicione mais mocks se quiser
        )
    }
}