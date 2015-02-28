package co.bohc.diet.domain.service.aws;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.jets3t.service.S3ServiceException;
import org.jets3t.service.ServiceException;
import org.jets3t.service.acl.AccessControlList;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;
import org.jets3t.service.model.S3Bucket;
import org.jets3t.service.model.S3Object;
import org.jets3t.service.model.StorageObject;
import org.jets3t.service.security.AWSCredentials;
import org.springframework.util.StringUtils;

import co.bohc.diet.domain.common.exception.NotFoundException;
import co.bohc.diet.domain.common.exception.S3Exception;

public class S3Service {
	private AWSCredentials awsCredentials;
	private String bucketName;

	public S3Service(String accessKey, String secretKey) {
		super();
		this.awsCredentials = new AWSCredentials(accessKey, secretKey);
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	private RestS3Service getService() {
		try {
			RestS3Service s3Service = new RestS3Service(awsCredentials);
			return s3Service;
		} catch (S3ServiceException e) {
			throw new S3Exception(e);
		}

	}

	public void save(String fileName, byte[] data, String folderName) {
		RestS3Service s3Service = this.getService();
		try {
			S3Object s3obj = new S3Object(fileName, data);
			if (StringUtils.hasText(folderName)) {
				s3obj.setKey(folderName + "/" + fileName);
			}
			S3Bucket bucket = s3Service.getOrCreateBucket(bucketName);

			bucket.setAcl(AccessControlList.REST_CANNED_PUBLIC_READ); // only
																		// owner
																		// can
																		// update
																		// ,public
																		// read
			s3obj.setAcl(AccessControlList.REST_CANNED_PUBLIC_READ_WRITE);
			s3Service.putObject(bucket, s3obj);
		} catch (NoSuchAlgorithmException | IOException | S3ServiceException e) {
			throw new S3Exception(e);
		} finally {
			try {
				s3Service.shutdown();
			} catch (ServiceException e) {
				throw new S3Exception(e);
			}
		}
	}

	public void delete(String fileName, String folderName) {
		RestS3Service s3Service = this.getService();
		try {
			String s3ObjKey = fileName;
			if (StringUtils.hasText(folderName)) {
				s3ObjKey = folderName + "/" + fileName;
			}
			s3Service.deleteObject(bucketName, s3ObjKey);

		} catch (ServiceException e) {
			throw new S3Exception(e);
		} finally {
			try {
				s3Service.shutdown();
			} catch (ServiceException e) {
				throw new S3Exception(e);
			}
		}

	}

	public void makePrivate(String fileName, String folderName) {
		RestS3Service s3Service = this.getService();
		try {
			String s3ObjKey = fileName;
			if (StringUtils.hasText(folderName)) {
				s3ObjKey = folderName + "/" + fileName;
			}
			s3Service.putObjectAcl(bucketName, s3ObjKey, AccessControlList.REST_CANNED_PRIVATE);
		} catch (ServiceException e) {
			throw new S3Exception(e);
		} finally {
			try {
				s3Service.shutdown();
			} catch (ServiceException e) {
				throw new S3Exception(e);
			}
		}
	}

	public void rename(String oldFileName, String newFileName, String folderName) {
		RestS3Service s3Service = this.getService();
		try {
			String s3ObjKey = oldFileName;
			String newS3ObjKey = newFileName;
			if (StringUtils.hasText(folderName)) {
				s3ObjKey = folderName + "/" + oldFileName;
			}

			StorageObject object = s3Service.getObject(bucketName, s3ObjKey);
			if (StringUtils.hasText(folderName)) {
				newS3ObjKey = folderName + "/" + newFileName;
			}
			object.setKey(newS3ObjKey);
			object.setAcl(AccessControlList.REST_CANNED_PUBLIC_READ_WRITE);
			s3Service.renameObject(bucketName, s3ObjKey, object);
		} catch (ServiceException e) {
			if (!e.getErrorCode().equals("NoSuchKey")) {
				throw new NotFoundException(e);
			} else {
				throw new S3Exception(e);
			}
		} finally {
			try {
				s3Service.shutdown();
			} catch (ServiceException e) {
				throw new S3Exception(e);
			}
		}
	}
}
