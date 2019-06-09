package com.gm.coding.exercise.data.source;

import com.gm.coding.exercise.data.source.remote.RemoteDataSource;

import dagger.Binds;
import dagger.Module;

/**
 * This is used by Dagger to inject the required arguments into the {@link Repository}.
 */
@Module
public abstract class RepositoryModule {
    @Binds
    abstract DataSource bindRemoteDataSource(RemoteDataSource remoteDataSource);
}
