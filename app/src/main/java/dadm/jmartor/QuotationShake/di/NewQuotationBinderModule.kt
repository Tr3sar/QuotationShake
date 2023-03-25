package dadm.jmartor.dadm.jmartor.QuotationShake.di

import dadm.jmartor.dadm.jmartor.QuotationShake.data.newquotation.NewQuotationRepository
import dadm.jmartor.dadm.jmartor.QuotationShake.data.newquotation.NewQuotationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NewQuotationBinderModule {
    @Binds
    abstract fun bindNewQuotationRepository(repository: NewQuotationRepositoryImpl) : NewQuotationRepository
}