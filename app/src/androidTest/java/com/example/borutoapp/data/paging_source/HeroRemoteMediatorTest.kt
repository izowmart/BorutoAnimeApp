package com.example.borutoapp.data.paging_source

import androidx.paging.*
import androidx.test.core.app.ApplicationProvider
import com.example.borutoapp.data.local.BorutoDatabase
import com.example.borutoapp.data.remote.FakeBorutoApi2
import com.example.borutoapp.domain.model.Hero
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
@ExperimentalPagingApi
class HeroRemoteMediatorTest {

    private lateinit var borutoApi: FakeBorutoApi2
    private lateinit var borutoDatabase: BorutoDatabase

    @Before
    fun setup(){
        borutoApi = FakeBorutoApi2()
        borutoDatabase = BorutoDatabase.create(
            context = ApplicationProvider.getApplicationContext(),
            useInMemory = true
        )
    }

    @After
    fun cleanup(){
        borutoDatabase.clearAllTables()
    }

    @Test
    fun refreshLoadReturnsSuccessResultWhenMoreDataIsPresent() =
        runBlocking {
            val remoteMediator = HeroRemoteMediator(
                borutoApi = borutoApi,
                borutoDatabase = borutoDatabase
            )
            val pagingState = PagingState<Int, Hero>(
                pages = listOf(),
                anchorPosition = null,
                config = PagingConfig(pageSize = 3),
                leadingPlaceholderCount = 0
            )
            val result = remoteMediator.load(LoadType.REFRESH,pagingState)
            assertTrue(result is RemoteMediator.MediatorResult.Success)
            assertFalse((result as RemoteMediator.MediatorResult.Success).endOfPaginationReached)
        }
}