# GMCodingExercise
GMCodingExercise Repo

This Application has one screen and it will show the recent commits for the particular public repository from GitHub. I have used the 'Flutter' repository - https://github.com/flutter/flutter and the Application will show the most recent commits of this repository.

This Application is following the MVP pattern and I have tried to use the Dagger2 for the dependency injection. To make the network call, I have used Retrofit library along with RxJava & Gson libraries. The Recycler View has been used to show the commits and I have followed the View Holder pattern. I have used the repository pattern in order to get data from different Data Sources like Remote(Network/API), Local(DB/Memory).

The GitHub Rest API V3 is used - https://developer.github.com/v3/
