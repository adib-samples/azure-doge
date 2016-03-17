package com.example;

import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

@Service
public class PhotoLibrary {
	
	private final String connectionString;

	@Autowired
	public PhotoLibrary(
			@Value("${azure.storage.account.name}") String accountName, 
			@Value("${azure.storage.account.key}") String accessKey)
	{
		
		this.connectionString = "DefaultEndpointsProtocol=http;" +
		                        "AccountName="+ accountName + 
		                        	";AccountKey=" + accessKey; 		
	}
	
	public byte[] getFromStorageAccount(String name) throws Exception {
		CloudStorageAccount storageAccount = CloudStorageAccount.parse(connectionString);
		CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
		CloudBlobContainer container = blobClient.getContainerReference("images");
		CloudBlockBlob blob = container.getBlockBlobReference(name);

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		blob.download(outStream);
		byte[] image = outStream.toByteArray();
		return image;
	}	
}
