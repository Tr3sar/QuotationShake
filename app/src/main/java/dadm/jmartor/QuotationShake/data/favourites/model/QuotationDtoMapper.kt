package dadm.jmartor.QuotationShake.data.favourites.model
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites.model.QuotationDto
import dadm.jmartor.QuotationShake.ui.domain.model.Quotation

fun QuotationDto.toDomain(): Quotation = Quotation(id = id, nombreCita = text, autorCita = author)

fun Quotation.toDto(): QuotationDto = QuotationDto(id = id, text = nombreCita, author = autorCita)