package com.grt.comunidadpropjetcomp.di

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.grt.comunidadpropjetcomp.data.Constants
import com.grt.comunidadpropjetcomp.data.firestore.FirestoreComunityRepository
import com.grt.comunidadpropjetcomp.domain.repository.GetComunityRepository
import com.grt.comunidadpropjetcomp.domain.usecase.GetComunityUseCase
import com.grt.comunidadpropjetcomp.domain.usecase.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideFirebaseFirestore() = Firebase.firestore

    @Provides
    fun provideComunitysRef(
        db: FirebaseFirestore
    ) = db.collection(Constants.COLL_COMUNITYS)

    @Provides
    fun provideComunitysRepository(
        comunitysRef: CollectionReference
    ): GetComunityRepository = FirestoreComunityRepository(comunitysRef)

    @Provides
    fun provideUseCases(
        repo: GetComunityRepository
    ) = UseCases(
        getComunitys = GetComunityUseCase(repo)
    )
}