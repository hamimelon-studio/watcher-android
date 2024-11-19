package com.mikeapp.watcher.data.github

import com.mikeapp.watcher.data.github.RepoConfig.owner
import com.mikeapp.watcher.data.github.RepoConfig.repo
import com.mikeapp.watcher.data.github.model.GitHubFileRequest
import com.mikeapp.watcher.data.github.model.GithubFileContent
import com.mikeapp.watcher.data.github.model.GithubFileMetadata
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface GithubApiService {
    // create file doesn't need sha if file isn't exist
    @PUT("repos/$owner/$repo/contents/{path}")
    suspend fun createFile(
        @Path("path")path: String,
        @Body requestBody: GitHubFileRequest
    ): Response<GithubFileMetadata>

    // sha must be provided for updating existing file
    @PUT("repos/$owner/$repo/contents/{path}")
    suspend fun updateFile(
        @Path("path")path: String,
        @Body requestBody: GitHubFileRequest
    ): Response<GithubFileMetadata>

    // get 404 if file isn't exist
    // get 200 and its metadata if exist
    @GET("repos/$owner/$repo/contents/{path}")
    suspend fun getFileMetadata(
        @Path("path") path: String
    ): Response<GithubFileMetadata>

    @GET("repos/$owner/$repo/contents/{path}")
    suspend fun getFileContent(@Path("path") path: String): Response<GithubFileContent>
}