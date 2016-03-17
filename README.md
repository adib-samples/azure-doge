# azure-doge

To run the application you need to first obtain your 

* Azure Storage Account name
* Azure Storage Account access key

The application also expects your storage account  to contain a container called `images` with a blob called `doge.jpeg` which will be the image to doge, these values are hardcoded in the name of simplicity feel free to change them. 

These values shoud be place in the `application.propreties` file and in the `manifest.yml` file if you don't have the correct access key and account name you will get an error message form the application on startup. 

The sample is stripped super simplifed version of the spring-doge sample from Josh Long by https://github.com/joshlong/spring-doge 

I found the following resources helpful for putting this sample togther. 

* [Introduction to Microsoft Azure Storage](https://azure.microsoft.com/en-us/documentation/articles/storage-introduction/#next-steps)
* [How to use Blob storage from Java](https://azure.microsoft.com/en-us/documentation/articles/storage-java-how-to-use-blob-storage/)
