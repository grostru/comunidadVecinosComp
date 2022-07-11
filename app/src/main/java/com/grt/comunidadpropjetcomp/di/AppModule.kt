package com.grt.comunidadpropjetcomp.di

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.grt.comunidadpropjetcomp.data.Constants
import com.grt.comunidadpropjetcomp.data.firestore.FirestoreComunityRepository
import com.grt.comunidadpropjetcomp.data.firestore.FirestoreTablonRepository
import com.grt.comunidadpropjetcomp.domain.repository.GetComunityRepository
import com.grt.comunidadpropjetcomp.domain.repository.GetProfileRepository
import com.grt.comunidadpropjetcomp.domain.repository.GetTablonRepository
import com.grt.comunidadpropjetcomp.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideFirebaseFirestore() = FirebaseFirestore.getInstance()

    @Provides
    fun provideComunitysRepository(
        db:FirebaseFirestore
    ): GetComunityRepository = FirestoreComunityRepository(db)

    @Provides
    fun provideTablonRepository(
        db: FirebaseFirestore
    ): GetTablonRepository = FirestoreTablonRepository(db)


    @Provides
    fun provideUseCases(
        repoCom: GetComunityRepository,
        repoTab: GetTablonRepository,
        repoProfile: GetProfileRepository
    ) = UseCases(
        getComunitys = GetComunityUseCase(repoCom),
        getTablon = GetTablonUseCase(repoTab),
        getIdComunity = GetProfileIdComunityUseCase(repoProfile),
        saveIdComunity = SaveProfileIdComunityUseCase(repoProfile)
    )

}