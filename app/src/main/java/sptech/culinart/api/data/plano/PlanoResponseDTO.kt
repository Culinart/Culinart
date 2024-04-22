package sptech.culinart.api.data.plano

import sptech.culinart.api.data.categoria.Categoria

data class PlanoResponseDTO(
    val id:Int,
    val qtdPessoas: Int,
    val qtdRefeicoesDia: Int,
    val qtdDiasSemana: Int,
    val valorPlano: Double,
    val valorAjuste: Double,
    val horaEntrega: String,
    val diaSemana: String,
    val isAtivo: String,
)
