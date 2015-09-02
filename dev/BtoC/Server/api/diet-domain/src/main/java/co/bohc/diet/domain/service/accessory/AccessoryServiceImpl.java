package co.bohc.diet.domain.service.accessory;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.nio.file.Paths;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.persistence.Access;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import co.bohc.diet.domain.common.utils.AddZeroUtil;
import co.bohc.diet.domain.common.utils.TimeUtils;
import co.bohc.diet.domain.model.Accessory;
import co.bohc.diet.domain.model.Model;
import co.bohc.diet.domain.model.Part;
import co.bohc.diet.domain.model.Style;
import co.bohc.diet.domain.repository.accessory.AccessoryOutput;
import co.bohc.diet.domain.repository.accessory.AccessoryRepository;
import co.bohc.diet.domain.repository.accessory.AccessorySearchPar;
import co.bohc.diet.domain.repository.model.ModelRepository;
import co.bohc.diet.domain.repository.part.PartRepository;
import co.bohc.diet.domain.repository.style.StyleRepository;

@Service
@Transactional(readOnly = true)
public class AccessoryServiceImpl implements AccessoryService {

	@Inject
	private AccessoryRepository accessoryRepository;
	@Inject
	private ModelRepository modelRepository;
	@Inject
	private PartRepository partRepository;
	@Inject
	private StyleRepository styleRepository;

	private static String indexpathAll = "/Users/local/lucene/luceneIndexAll/";

	private static String indexpath = "/Users/local/lucene/luceneIndex/";

	private static String indexpathA = "/Users/local/lucene/luceneIndexA/";

	private static String rootPath = "/Users/local/workspace/czglxt/html/image/img/zp/";

	private static String photoUpload = "/Users/local/lucene/fileUpload/";

	private static String photoUpload_B = "/Users/local/lucene/fileUploadB/";

	private static String photoUpload_A = "/Users/local/lucene/A_class/";

	private static String indexPathSaled = "/Users/local/lucene/luceneSaled/";

	private static String saled_class = "/Users/local/lucene/saledFile/";

	// @Override
	// public List<Accessory> findByModelStylePart(String modelName, String
	// styleName, String partName) {
	// List<Accessory> accessories =
	// accessoryRepository.findByModelStylePart(modelName, styleName, partName);
	// return accessories;
	// }

	@Override
	public List<Accessory> findByCreDt() {
		List<Accessory> accessories = accessoryRepository.findByCreDt();
		return accessories;
	}

	// @Override
	// public void saveAccessory(String level, Integer modelId, Integer styleId,
	// Integer partId, String imgDataUrl) {
	// String accessoryImg = generateImage(modelId, styleId, partId,
	// imgDataUrl);
	// Model model = modelRepository.findOne(modelId);
	// Style style = styleRepository.findOne(styleId);
	// Part part = partRepository.findOne(partId);
	// String accessoryName = model.getBrand().getBrandName() + " " +
	// model.getModelName() + " "
	// + style.getStyleName() + " " + part.getPartName();
	// Accessory accessory = new Accessory();
	// accessory.setAccessoryImg(accessoryImg);
	// accessory.setAccessoryName(accessoryName);
	// accessory.setAccessoryNum(getImgName(modelId, styleId, partId));
	// accessory.setCreDt(new Date());
	// // accessory.setModel(model);
	// // accessory.setPart(part);
	// // accessory.setStyle(style);
	// accessory.setLevel(level);
	// accessoryRepository.save(accessory);
	//
	// }

	// public String generateImage(Integer modelId, Integer styleId, Integer
	// partId, String imgDataUrl) { // 对字节数组字符串进行Base64解码并生成图片
	// String modelIdStr = String.valueOf(modelId);
	// String styleIdStr = String.valueOf(styleId);
	// String partIdStr = String.valueOf(partId);
	// if (imgDataUrl == null) // 图像数据为空
	// return null;
	// BASE64Decoder decoder = new BASE64Decoder();
	// imgDataUrl = imgDataUrl.split(",")[1];
	// try {
	// // Base64解码
	// byte[] b = decoder.decodeBuffer(imgDataUrl);
	// // for(int i=0;i<b.length;++i)
	// // {
	// // if(b[i]<0)
	// // {//调整异常数据
	// // b[i]+=256;
	// // }
	// // }
	// // 生成jpeg图片
	// String imgName = "image/img/" + modelIdStr + "/" + styleIdStr + "/" +
	// partIdStr + "/"
	// + getImgName(modelId, styleId, partId) + ".jpg";
	// File pageElementFileDir = new
	// File("c://project//czxsxt//html//image//img//" + modelIdStr + "//"
	// + styleIdStr + "//" + partIdStr);
	// if (!pageElementFileDir.exists()) {
	// pageElementFileDir.mkdirs();
	// }
	// String imgFilePath = "c://project//czxsxt//html//image//img//" +
	// modelIdStr + "//" + styleIdStr + "//"
	// + partIdStr + "//" + getImgName(modelId, styleId, partId) + ".jpg";//
	// 新生成的图片
	// OutputStream out = new FileOutputStream(imgFilePath);
	// out.write(b);
	// out.flush();
	// out.close();
	// return imgName;
	// } catch (Exception e) {
	// return null;
	// }
	// }

	// private String getImgName(Integer modelId, Integer styleId, Integer
	// partId) {
	// Integer count = accessoryRepository.findCountByMSP(modelId, styleId,
	// partId);
	// if (count == null) {
	// count = 0;
	// } else {
	// count = count + 1;
	// }
	// String modelIdStr = String.valueOf(modelId);
	// String styleIdStr = String.valueOf(styleId);
	// String partIdStr = String.valueOf(partId);
	// String countNumStr = String.valueOf(count);
	// if (modelIdStr.length() == 1) {
	// modelIdStr = "00" + modelIdStr;
	// } else if (modelIdStr.length() == 2) {
	// modelIdStr = "0" + modelIdStr;
	// }
	// if (styleIdStr.length() == 1) {
	// styleIdStr = "0" + styleIdStr;
	// // } else if (styleIdStr.length() == 2) {
	// // styleIdStr = "0" + styleIdStr;
	// }
	// if (partIdStr.length() == 1) {
	// partIdStr = "00" + partIdStr;
	// } else if (partIdStr.length() == 2) {
	// partIdStr = "0" + partIdStr;
	// }
	// Integer zeroNum = 5 - countNumStr.length();
	// for (int i = 0; i < zeroNum; i++) {
	// countNumStr = "0" + countNumStr;
	// }
	// return modelIdStr + styleIdStr + partIdStr + countNumStr;
	// }

	// @Override
	// public Page<Accessory> findByBrandId(Integer brandId, Pageable pageable)
	// {
	// List<Accessory> accessories = accessoryRepository.findByBrandId(brandId,
	// pageable);
	// Integer count = accessoryRepository.countByBrandId(brandId);
	// Page<Accessory> page = new PageImpl<Accessory>(accessories, pageable,
	// count);
	// if (accessories == null) {
	// return null;
	// }
	// return page;
	// }

	@Override
	public Page<Accessory> findByParam(AccessorySearchPar accessorySearchPar, Pageable pageable) {
		List<Accessory> accessories = accessoryRepository.findByParam(accessorySearchPar, pageable);
		Long count = accessoryRepository.countByParam(accessorySearchPar);
		return new PageImpl<Accessory>(accessories, pageable, count);
	}

	@Override
	public List<Accessory> findByParamSale(AccessorySearchPar accessorySearchPar) {
		return accessoryRepository.findByParamSale(accessorySearchPar);
	}

	// @Override
	// public List<Accessory> findByBrandIdSale(Integer brandId) {
	// List<Accessory> accessories = null;
	// if (brandId == null) {
	// accessories = accessoryRepository.findByCreDtSale();
	// } else {
	// accessories = accessoryRepository.findByBrandIdAndSale(brandId);
	// }
	// if (accessories == null) {
	// return null;
	// }
	// return accessories;
	// }

	// @Override
	// public List<Accessory> findByBrandIdAndSale(Integer brandId) {
	// List<Accessory> accessories =
	// accessoryRepository.findByBrandIdAndSale(brandId);
	// if (accessories == null) {
	// return null;
	// }
	// return accessories;
	// }

	@Override
	@Transactional
	public Accessory saveSaleMoney(Integer accessoryId, Double saleMoney) {
		Accessory accessory = accessoryRepository.findOne(accessoryId);
		if (accessory == null || accessory.getSaleDt() != null) {
			return null;
		}
		accessory.setSaleDt(new Date());
		accessory.setSaleMoney(saleMoney);
		accessoryRepository.save(accessory);
		return accessory;
	}

	@Override
	public LucenePage SearchByLucene(String key, Integer page) {
		try {
			return lucene(key, page);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private LucenePage lucene(String key, Integer page) throws IOException, ParseException {
		Analyzer analyzer = new StandardAnalyzer();
		Directory directory = FSDirectory.open(Paths.get(indexpath));
		DirectoryReader iReader = DirectoryReader.open(directory);
		IndexSearcher iSearcher = new IndexSearcher(iReader);
		String[] multiFields = { "fileName", "photoId" };
		MultiFieldQueryParser parser = new MultiFieldQueryParser(multiFields, analyzer);
		Query query = parser.parse(key);
		TopDocs docs = null;
		Integer count = null;
		if (page != null && page == 0) {
			docs = iSearcher.search(query, 16);
		} else {
			docs = iSearcher.search(query, 16 * page);
			ScoreDoc[] hits = docs.scoreDocs;
			docs = iSearcher.searchAfter(hits[hits.length - 1], query, 16);
		}
		count = iSearcher.count(query);
		ScoreDoc[] hits = docs.scoreDocs;
		// docs = iSearcher.searchAfter(hits[hits.length - 1], query, 2);
		// hits = docs.scoreDocs;
		System.out.println(count);
		System.out.println(hits.length);

		// SimpleHTMLFormatter simpleHTMLFormatter = new
		// SimpleHTMLFormatter("<span style='color:green'>", "</span>");
		// Highlighter highlighter = new Highlighter(simpleHTMLFormatter, new
		// QueryScorer(query));
		// highlighter.setTextFragmenter(new SimpleFragmenter(100));
		System.out.println("Searched " + hits.length + " documents.");
		// Iteratethrough the results:
		List<LuceneOutput> luceneOutputs = new ArrayList<LuceneOutput>();
		LuceneOutput luceneOutput = null;
		for (int i = 0; i < hits.length; i++) {
			Document hitDoc = iSearcher.doc(hits[i].doc);
			String[] scoreExplain = null;
			// scoreExplain可以显示文档的得分详情，这里用split截取总分
			scoreExplain = iSearcher.explain(query, hits[i].doc).toString().split(" ", 2);
			String scores = scoreExplain[0];
			// assertEquals("Thisis the text to be indexed.",
			// hitDoc.get("fieldname"));
			System.out.println("score:" + scores);
			String value = hitDoc.get("fileName");
			String id = hitDoc.get("photoId");
			String photoPath = hitDoc.get("photoPath");
			luceneOutput = new LuceneOutput(value, id, GetImageStr(photoPath));
			luceneOutputs.add(luceneOutput);
			// TokenStream tokenStream = analyzer.tokenStream(value, new
			// StringReader(value));
			// String str1 = highlighter.getBestFragment(tokenStream, value);

			System.out.println(value);
			System.out.println(id);
		}
		LucenePage lucenePage = new LucenePage();
		lucenePage.setContent(luceneOutputs);
		lucenePage.setSize(hits.length);
		lucenePage.setTotalElements(count);
		if (hits.length == 0) {
			lucenePage.setPage(0);
		} else {
			lucenePage.setPage(count / hits.length);
		}
		iReader.close();
		directory.close();
		return lucenePage;
	}

	@Override
	public void savePicture() {
		Analyzer analyzer = new StandardAnalyzer();
		Directory directory = null;
		IndexWriter iWriter = null;
		try {
			directory = FSDirectory.open(Paths.get(indexpath));
			IndexWriterConfig config = new IndexWriterConfig(analyzer);
			iWriter = new IndexWriter(directory, config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * 根据照片添加索引
		 */
		File upLoadFile = new File(photoUpload);
		File rootFile = new File(rootPath);
		String[] photoLib = rootFile.list();
		String[] photos = upLoadFile.list();
		Integer photoLibNum = photoLib.length;
		Document doc = null;
		Accessory accessory = null;
		Date date = new Date();
		for (int i = 0; i < photos.length; i++) {
			accessory = new Accessory();
			String photoName = copyFile(photos[i].toString());
			doc = new Document();
			doc.add(new Field("fileName", photoName, TextField.TYPE_STORED));
			doc.add(new Field("photoId", AddZeroUtil.addZero(photoLibNum + i, 7), TextField.TYPE_STORED));
			doc.add(new Field("creDt", TimeUtils.datetimeToStr(date), TextField.TYPE_STORED));
			doc.add(new Field("photoPath", "image/img/zp/" + photos[i].toString(), TextField.TYPE_STORED));
			try {
				iWriter.addDocument(doc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			accessory.setAccessoryName(photoName);
			accessory.setCreDt(date);
			accessory.setAccessoryImg(rootPath + photoName + "/" + photos[i].toString().split("/")[1]);
			accessory.setAccessoryNum(AddZeroUtil.addZero(photoLibNum + i, 7));
			accessory.setLevel("1");
			accessory.setModelId(1);
			accessory.setPartId(1);
			accessory.setStyleId(1);
			accessoryRepository.save(accessory);
		}
		try {
			iWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String copyFile(String fileName) {
		System.out.println("begin copy: " + fileName);
		String fileNameResult = null;
		try {
			int i = 1;
			int bytesum = 0;
			int byteread = 0;
			String oldPath = photoUpload + fileName;
			String newPath = rootPath + fileName;
			File oldFile = new File(oldPath);
			File newFile = new File(newPath);
			String fileNameFirst = fileName.split("\\.")[0];
			fileNameResult = fileNameFirst;
			String fileNameSec = fileName.split("\\.")[1];
			while (newFile.exists()) {
				fileNameResult = fileNameFirst + "_" + i;
				newPath = rootPath + "\\" + fileNameFirst + "_" + i + "." + fileNameSec;
				newFile = new File(newPath);
				i++;
			}
			if (oldFile.exists()) { // 文件存在时
				InputStream inStream = new FileInputStream(oldPath); // 读入原文件
				OutputStream fs = new FileOutputStream(newPath);
				resizeImage(inStream, fs, 900, "JPG");
				// byte[] buffer = new byte[1024 * 10];
				// int length;
				// while ((byteread = inStream.read(buffer)) != -1) {
				// bytesum += byteread; // 字节数 文件大小
				// System.out.println(bytesum);
				// fs.write(buffer, 0, byteread);
				// }
				inStream.close();
			}
			oldFile.delete();
		} catch (Exception e) {
			System.out.println("复制单个文件操作出错");
			e.printStackTrace();
		}
		return fileNameResult;
	}

	public static void resizeImage(InputStream is, OutputStream os, int size, String format) throws IOException {
		size = 500;
		BufferedImage prevImage = ImageIO.read(is);
		double width = prevImage.getWidth();
		double height = prevImage.getHeight();
		double percent = size / width;
		int newWidth = (int) (width * percent);
		int newHeight = (int) (height * percent);
		BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_BGR);
		Graphics graphics = image.createGraphics();
		graphics.drawImage(prevImage, 0, 0, newWidth, newHeight, null);
		ImageIO.write(image, format, os);
		os.flush();
		is.close();
		os.close();
	}

	@Override
	public List<LuceneOutput> searchByLuceneDate(String key) {
		Analyzer analyzer = new StandardAnalyzer();
		Directory directory;
		DirectoryReader iReader = null;
		try {
			directory = FSDirectory.open(Paths.get(indexpath));
			iReader = DirectoryReader.open(directory);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IndexSearcher iSearcher = new IndexSearcher(iReader);
		QueryParser parser = new QueryParser("creDt", analyzer);
		Query query = null;
		Integer count = null;
		TopDocs docs = null;
		try {
			query = parser.parse(key);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			count = iSearcher.count(query);
			docs = iSearcher.search(query, count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ScoreDoc[] hits = docs.scoreDocs;
		// docs = iSearcher.searchAfter(hits[hits.length - 1], query, 2);
		// hits = docs.scoreDocs;
		System.out.println(count);
		System.out.println(hits.length);
		List<LuceneOutput> luceneOutputs = new ArrayList<LuceneOutput>();
		LuceneOutput luceneOutput = null;
		for (int i = 0; i < hits.length; i++) {
			Document hitDoc = null;
			String[] scoreExplain = null;
			try {
				hitDoc = iSearcher.doc(hits[i].doc);
				scoreExplain = iSearcher.explain(query, hits[i].doc).toString().split(" ", 2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String scores = scoreExplain[0];
			// assertEquals("Thisis the text to be indexed.",
			// hitDoc.get("fieldname"));
			System.out.println("score:" + scores);
			String value = hitDoc.get("fileName");
			String id = hitDoc.get("photoId");
			String photoPath = hitDoc.get("photoPath");
			String creDt = hitDoc.get("creDt");
			String level = hitDoc.get("level");
			luceneOutput = new LuceneOutput(value, id, photoPath, creDt, level);
			luceneOutputs.add(luceneOutput);
			// TokenStream tokenStream = analyzer.tokenStream(value, new
			// StringReader(value));
			// String str1 = highlighter.getBestFragment(tokenStream, value);

			System.out.println(value);
			System.out.println(id);
		}
		return luceneOutputs;
	}

	@Override
	public List<Accessory> findByDate(String dateStr) {
		Date date = TimeUtils.strToDate(dateStr);
		Date fromDt = TimeUtils.getStartTimeOfDay(date);
		Date toDt = TimeUtils.getEndTimeOfDay(date);
		List<Accessory> list = accessoryRepository.findByDate(fromDt, toDt);
		for (int i = 0; i < list.size(); i++) {
			// list.get(i).setModelId(null);
			// list.get(i).setPartId(null);
			// list.get(i).setStyleId(null);
			list.get(i).setAccessoryImg(GetImageStr(list.get(i).getAccessoryImg()));
		}
		return list;
	}

	@Override
	@Transactional
	public void savePictureToA(String partId) {
		Analyzer analyzer = new StandardAnalyzer();
		Directory dirAll = null;
		IndexWriter iWriterAll = null;
		Directory dirB = null;
		Directory directory = null;
		IndexWriter iWriter = null;
		try {
			dirAll = FSDirectory.open(Paths.get(indexpathAll));
			dirB = FSDirectory.open(Paths.get(indexpath));
			directory = FSDirectory.open(Paths.get(indexpathA));
			IndexWriterConfig config = new IndexWriterConfig(analyzer);
			IndexWriterConfig configAll = new IndexWriterConfig(analyzer);
			iWriterAll = new IndexWriter(dirAll, configAll);
			iWriter = new IndexWriter(directory, config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File photoUploadFile = new File(photoUpload);
		String[] fileNames = photoUploadFile.list();
		File fromPhoto = null;
		File toPhoto = null;
		Date date = new Date();
		Date fromDt = TimeUtils.getStartTimeOfMonth(date);
		Date toDt = TimeUtils.getEndTimeOfMonth(date);
		Integer s = accessoryRepository.countByMonth(fromDt, toDt);
		for (int i = 0; i < fileNames.length; i++) {
			if (fileNames[i].equals(".DS_Store")) {

			} else {
				fromPhoto = new File(photoUpload + fileNames[i]);
				toPhoto = new File(photoUpload_A + fileNames[i]);
				int l = 1;
				String fileName = fileNames[i];
				while (toPhoto.exists()) {
					fileName = fileNames[i].split("\\.")[0] + "_" + l + "." + fileNames[i].split("\\.")[1];
					toPhoto = new File(photoUpload_A + fileName);
					l++;
				}
				try {
					toPhoto.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				OutputStream fs;
				InputStream inStream;
				try {
					inStream = new FileInputStream(fromPhoto); // 读入原文件
					fs = new FileOutputStream(toPhoto);
					resizeImage(inStream, fs, 900, "JPG");
					inStream.close();
					fromPhoto.delete();
					Accessory accessory = new Accessory();
					accessory.setAccessoryName(fileName.split("\\.")[0]);
					accessory.setCreDt(date);
					accessory.setAccessoryImg(photoUpload_A + fileName);
					accessory.setAccessoryNum(AddZeroUtil.addZero(s + i + 1, 8));
					accessory.setLevel("1");
					accessory.setModelId(1);
					accessory.setPartId(Integer.valueOf(partId));
					accessory.setStyleId(1);
					accessoryRepository.save(accessory);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Document doc = new Document();
				doc.add(new Field("fileName", fileName.split("\\.")[0], TextField.TYPE_STORED));
				doc.add(new Field("photoId", AddZeroUtil.addZero(s + i + 1, 8), TextField.TYPE_STORED));
				doc.add(new Field("creDt", TimeUtils.datetimeToStr(date), TextField.TYPE_STORED));
				doc.add(new Field("photoPath", photoUpload_A + fileName, TextField.TYPE_STORED));
				doc.add(new Field("partId", partId, TextField.TYPE_STORED));
				doc.add(new Field("level", "1", TextField.TYPE_STORED));
				doc.add(new Field("msg", "无备注", TextField.TYPE_STORED));
				try {
					iWriter.addDocument(doc);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		try {
			iWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (dirAll.listAll() != null && dirAll.listAll().length != 1) {
				iWriterAll.deleteAll();
			}
			if (directory.listAll() != null && directory.listAll().length != 0) {
				iWriterAll.addIndexes(directory);
			}
			if (dirB.listAll() != null && dirB.listAll().length != 1 && dirB.listAll().length != 2) {
				iWriterAll.addIndexes(dirB);
			}
			iWriterAll.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String GetImageStr(String imgFile) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}

	@Override
	public Accessory findByNum(String accessoryNum) {
		Accessory accessory = accessoryRepository.findOneByNum(accessoryNum);
		accessory.setAccessoryImg("data:image/png;base64," + GetImageStr(accessory.getAccessoryImg()));
		return accessory;
	}

	@Override
	@Transactional
	public void changeAccessory(String accessoryNum, String level, Integer partId, String msg, Integer saleMoney,
			MultipartFile mf) {
		Accessory accessory = accessoryRepository.findOneByNum(accessoryNum);
		if (saleMoney != null && !saleMoney.equals("")) {
			Analyzer analyzerA = new StandardAnalyzer();
			Directory directoryA = null;
			IndexWriter iWriterA = null;
			Directory dirAll = null;
			IndexWriter iWriterAll = null;
			Directory directorySaled = null;
			IndexWriter iWriterSaled = null;
			if (accessory.getLevel().equals("1")) {
				try {
					directoryA = FSDirectory.open(Paths.get(indexpathA));
					dirAll = FSDirectory.open(Paths.get(indexpathAll));
					IndexWriterConfig config = new IndexWriterConfig(analyzerA);
					IndexWriterConfig configAll = new IndexWriterConfig(analyzerA);
					iWriterA = new IndexWriter(directoryA, config);
					iWriterAll = new IndexWriter(dirAll, configAll);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
			} else {
				try {
					directoryA = FSDirectory.open(Paths.get(indexpath));
					dirAll = FSDirectory.open(Paths.get(indexpathAll));
					IndexWriterConfig config = new IndexWriterConfig(analyzerA);
					IndexWriterConfig configAll = new IndexWriterConfig(analyzerA);
					iWriterA = new IndexWriter(directoryA, config);
					iWriterAll = new IndexWriter(dirAll, configAll);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
			}
			QueryParser parser = new QueryParser("photoId", analyzerA);
			Query query;
			try {
				query = parser.parse(accessoryNum);
				iWriterA.deleteDocuments(query);
				iWriterAll.deleteDocuments(query);
			} catch (ParseException | IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				directorySaled = FSDirectory.open(Paths.get(indexPathSaled));
				IndexWriterConfig config = new IndexWriterConfig(analyzerA);
				iWriterSaled = new IndexWriter(directorySaled, config);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File oldFile = new File(accessory.getAccessoryImg());
			String saledFileName = accessory.getAccessoryImg()
					.substring(accessory.getAccessoryImg().lastIndexOf("/") + 1);
			File saledFile = new File(saled_class + saledFileName);
			int i = 1;
			String fileBNameNew = saledFileName;
			while (saledFile.exists()) {
				fileBNameNew = saledFileName.split("\\.")[0] + "_" + i + "." + saledFileName.split("\\.")[1];
				saledFile = new File(saled_class + fileBNameNew);
				i++;
			}
			try {
				saledFile.createNewFile();
				OutputStream fs = new FileOutputStream(saledFile);
				InputStream is = new FileInputStream(oldFile);
				byte[] bytes = new byte[1024 * 10];
				int num = -1;
				while ((num = is.read(bytes)) != -1) {
					fs.write(bytes, 0, num);
				}
				;
				fs.close();
				is.close();
				oldFile.delete();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Date date = new Date();
			Document doc = new Document();
			doc.add(new Field("fileName", accessory.getAccessoryName(), TextField.TYPE_STORED));
			doc.add(new Field("photoId", accessory.getAccessoryNum(), TextField.TYPE_STORED));
			doc.add(new Field("creDt", TimeUtils.datetimeToStr(date), TextField.TYPE_STORED));
			doc.add(new Field("photoPath", saled_class + fileBNameNew, TextField.TYPE_STORED));
			doc.add(new Field("partId", partId.toString(), TextField.TYPE_STORED));
			doc.add(new Field("level", accessory.getLevel(), TextField.TYPE_STORED));
			doc.add(new Field("msg", msg, TextField.TYPE_STORED));
			System.out.println(saled_class + fileBNameNew);
			try {
				iWriterSaled.addDocument(doc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			accessory.setPartId(partId);
			accessory.setMsg(msg);
			accessory.setAccessoryImg(saled_class + fileBNameNew);
			accessory.setSaleMoney(Double.valueOf(String.valueOf(saleMoney)));
			accessory.setSaleDt(date);
			accessoryRepository.save(accessory);
			try {
				iWriterSaled.close();
				iWriterA.close();
				iWriterAll.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		if (accessory.getLevel().equals(level) && accessory.getPartId() == partId && mf == null
				&& (msg == "" || msg == null)) {
			return;
		}
		if (accessory.getLevel().equals(level) && accessory.getPartId() == partId && mf != null && !mf.isEmpty()) {
			accessory.setMsg(msg);
			InputStream is = null;
			OutputStream os = null;
			File oldFile = null;
			if (mf != null && !mf.isEmpty()) {
				try {
					oldFile = new File(accessory.getAccessoryImg());
					os = new FileOutputStream(oldFile);
					is = mf.getInputStream();
					oldFile.delete();
					oldFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					resizeImage(is, os, 300, "JPG");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			accessoryRepository.save(accessory);
		} else if (accessory.getLevel().equals(level)) {
			if (accessory.getLevel().equals("1")) {
				Analyzer analyzerA = new StandardAnalyzer();
				Directory directoryA = null;
				Directory dirAll = null;
				IndexWriter iWriterA = null;
				IndexWriter iWriterAll = null;
				try {
					directoryA = FSDirectory.open(Paths.get(indexpathA));
					dirAll = FSDirectory.open(Paths.get(indexpathAll));
					IndexWriterConfig config = new IndexWriterConfig(analyzerA);
					IndexWriterConfig configAll = new IndexWriterConfig(analyzerA);
					iWriterA = new IndexWriter(directoryA, config);
					iWriterAll = new IndexWriter(dirAll, configAll);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				QueryParser parser = new QueryParser("photoId", analyzerA);
				Query query;
				try {
					query = parser.parse(accessoryNum);
					iWriterA.deleteDocuments(query);
					iWriterAll.deleteDocuments(query);
				} catch (ParseException | IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				Document doc = new Document();
				doc.add(new Field("fileName", accessory.getAccessoryName(), TextField.TYPE_STORED));
				doc.add(new Field("photoId", accessory.getAccessoryNum(), TextField.TYPE_STORED));
				doc.add(new Field("creDt", TimeUtils.dateToStr(accessory.getCreDt()), TextField.TYPE_STORED));
				doc.add(new Field("photoPath", accessory.getAccessoryImg(), TextField.TYPE_STORED));
				doc.add(new Field("partId", partId.toString(), TextField.TYPE_STORED));
				doc.add(new Field("level", "1", TextField.TYPE_STORED));
				doc.add(new Field("msg", msg, TextField.TYPE_STORED));
				try {
					iWriterA.addDocument(doc);
					iWriterAll.addDocument(doc);
					iWriterA.close();
					iWriterAll.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				InputStream is = null;
				OutputStream os = null;
				File oldFile = null;
				if (mf != null && !mf.isEmpty()) {
					try {
						oldFile = new File(accessory.getAccessoryImg());
						os = new FileOutputStream(oldFile);
						is = mf.getInputStream();
						oldFile.delete();
						oldFile.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						resizeImage(is, os, 300, "JPG");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else if (accessory.getLevel().equals("2")) {
				Analyzer analyzer = new StandardAnalyzer();
				Directory directory = null;
				Directory dirAll = null;
				IndexWriter iWriter = null;
				IndexWriter iWriterAll = null;
				try {
					directory = FSDirectory.open(Paths.get(indexpath));
					dirAll = FSDirectory.open(Paths.get(indexpathAll));
					IndexWriterConfig config = new IndexWriterConfig(analyzer);
					IndexWriterConfig configAll = new IndexWriterConfig(analyzer);
					iWriter = new IndexWriter(directory, config);
					iWriterAll = new IndexWriter(dirAll, configAll);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				QueryParser parser = new QueryParser("photoId", analyzer);
				Query query;
				try {
					query = parser.parse(accessoryNum);
					iWriter.deleteDocuments(query);
					iWriterAll.deleteDocuments(query);
				} catch (ParseException | IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				Document doc = new Document();
				doc.add(new Field("fileName", accessory.getAccessoryName(), TextField.TYPE_STORED));
				doc.add(new Field("photoId", accessory.getAccessoryNum(), TextField.TYPE_STORED));
				doc.add(new Field("creDt", TimeUtils.dateToStr(accessory.getCreDt()), TextField.TYPE_STORED));
				doc.add(new Field("photoPath", accessory.getAccessoryImg(), TextField.TYPE_STORED));
				doc.add(new Field("partId", partId.toString(), TextField.TYPE_STORED));
				doc.add(new Field("level", "2", TextField.TYPE_STORED));
				doc.add(new Field("msg", msg, TextField.TYPE_STORED));
				try {
					iWriter.addDocument(doc);
					iWriterAll.addDocument(doc);
					iWriter.close();
					iWriterAll.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			InputStream is = null;
			OutputStream os = null;
			File oldFile = null;
			if (mf != null && !mf.isEmpty()) {
				try {
					oldFile = new File(accessory.getAccessoryImg());
					os = new FileOutputStream(oldFile);
					is = mf.getInputStream();
					oldFile.delete();
					oldFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					resizeImage(is, os, 300, "JPG");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			accessory.setPartId(partId);
			accessory.setMsg(msg);
			accessoryRepository.save(accessory);
		} else if (!accessory.getLevel().equals(level)) {
			if ("2".equals(level)) {
				Analyzer analyzerA = new StandardAnalyzer();
				Directory dirAll = null;
				Directory directoryA = null;
				IndexWriter iWriterA = null;
				IndexWriter iWriterAll = null;
				try {
					dirAll = FSDirectory.open(Paths.get(indexpathAll));
					directoryA = FSDirectory.open(Paths.get(indexpathA));
					IndexWriterConfig config = new IndexWriterConfig(analyzerA);
					IndexWriterConfig configAll = new IndexWriterConfig(analyzerA);
					iWriterA = new IndexWriter(directoryA, config);
					iWriterAll = new IndexWriter(dirAll, configAll);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				QueryParser parser = new QueryParser("photoId", analyzerA);
				Query query;
				try {
					query = parser.parse(accessoryNum);
					iWriterA.deleteDocuments(query);
					iWriterAll.deleteDocuments(query);
				} catch (ParseException | IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				Analyzer analyzer = new StandardAnalyzer();
				Directory directory = null;
				IndexWriter iWriter = null;
				try {
					directory = FSDirectory.open(Paths.get(indexpath));
					IndexWriterConfig config = new IndexWriterConfig(analyzer);
					iWriter = new IndexWriter(directory, config);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/**
				 * 根据照片添加索引
				 */
				File accessoryFileA = new File(accessory.getAccessoryImg());
				String fileBName = accessory.getAccessoryImg()
						.substring(accessory.getAccessoryImg().lastIndexOf("/") + 1);
				File accessoryFileB = new File(rootPath + fileBName);
				int i = 1;
				String fileBNameNew = fileBName;
				while (accessoryFileB.exists()) {
					fileBNameNew = fileBName.split("\\.")[0] + "_" + i + "." + fileBName.split("\\.")[1];
					accessoryFileB = new File(rootPath + fileBNameNew);
					i++;
				}
				try {
					accessoryFileB.createNewFile();
					OutputStream fs = new FileOutputStream(accessoryFileB);
					InputStream is = new FileInputStream(accessoryFileA);
					byte[] bytes = new byte[1024 * 10];
					int num = -1;
					while ((num = is.read(bytes)) != -1) {
						fs.write(bytes, 0, num);
					}
					;
					fs.close();
					is.close();
					accessoryFileA.delete();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Document doc = null;
				Date date = new Date();
				doc = new Document();
				doc.add(new Field("fileName", fileBNameNew.split("\\.")[0], TextField.TYPE_STORED));
				doc.add(new Field("photoId", accessory.getAccessoryNum(), TextField.TYPE_STORED));
				doc.add(new Field("creDt", TimeUtils.datetimeToStr(date), TextField.TYPE_STORED));
				doc.add(new Field("photoPath", rootPath + fileBNameNew, TextField.TYPE_STORED));
				doc.add(new Field("partId", partId.toString(), TextField.TYPE_STORED));
				doc.add(new Field("level", "2", TextField.TYPE_STORED));
				doc.add(new Field("msg", msg, TextField.TYPE_STORED));
				System.out.println(rootPath + fileBNameNew);
				try {
					iWriter.addDocument(doc);
					iWriterAll.addDocument(doc);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				accessory.setPartId(partId);
				accessory.setMsg(msg);
				accessory.setLevel(level);
				accessory.setAccessoryImg(rootPath + fileBNameNew);
				accessoryRepository.save(accessory);
				try {
					iWriter.close();
					iWriterA.close();
					iWriterAll.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				InputStream is = null;
				OutputStream os = null;
				File oldFile = null;
				if (mf != null && !mf.isEmpty()) {
					try {
						oldFile = new File(accessory.getAccessoryImg());
						os = new FileOutputStream(oldFile);
						is = mf.getInputStream();
						oldFile.delete();
						oldFile.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						resizeImage(is, os, 300, "JPG");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else if ("1".equals(level)) {
				Analyzer analyzer = new StandardAnalyzer();
				Directory dirAll = null;
				Directory directory = null;
				IndexWriter iWriter = null;
				IndexWriter iWriterAll = null;
				try {
					directory = FSDirectory.open(Paths.get(indexpath));
					dirAll = FSDirectory.open(Paths.get(indexpathAll));
					IndexWriterConfig config = new IndexWriterConfig(analyzer);
					IndexWriterConfig configAll = new IndexWriterConfig(analyzer);
					iWriter = new IndexWriter(directory, config);
					iWriterAll = new IndexWriter(dirAll, configAll);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				QueryParser parser = new QueryParser("photoId", analyzer);
				Query query;
				try {
					query = parser.parse(accessoryNum);
					iWriter.deleteDocuments(query);
					iWriterAll.deleteDocuments(query);
				} catch (ParseException | IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				Analyzer analyzerA = new StandardAnalyzer();
				Directory directoryA = null;
				IndexWriter iWriterA = null;
				try {
					directoryA = FSDirectory.open(Paths.get(indexpathA));
					IndexWriterConfig config = new IndexWriterConfig(analyzerA);
					iWriterA = new IndexWriter(directoryA, config);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/**
				 * 根据照片添加索引
				 */
				File accessoryFileA = new File(accessory.getAccessoryImg());
				String fileBName = accessory.getAccessoryImg()
						.substring(accessory.getAccessoryImg().lastIndexOf("/") + 1);
				File accessoryFileB = new File(photoUpload_A + fileBName);
				int i = 1;
				String fileBNameNew = fileBName;
				while (accessoryFileB.exists()) {
					fileBNameNew = fileBName.split("\\.")[0] + i + "." + fileBName.split("\\.")[1];
					accessoryFileB = new File(fileBNameNew);
					i++;
				}
				try {
					accessoryFileB.createNewFile();
					OutputStream fs = new FileOutputStream(accessoryFileB);
					InputStream is = new FileInputStream(accessoryFileA);
					byte[] bytes = new byte[1024 * 10];
					int num = -1;
					while ((num = is.read(bytes)) != -1) {
						fs.write(bytes, 0, num);
					}
					;
					fs.close();
					is.close();
					accessoryFileA.delete();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Document doc = null;
				Date date = new Date();
				doc = new Document();
				doc.add(new Field("fileName", fileBNameNew.split("\\.")[0], TextField.TYPE_STORED));
				doc.add(new Field("photoId", accessory.getAccessoryNum(), TextField.TYPE_STORED));
				doc.add(new Field("creDt", TimeUtils.datetimeToStr(date), TextField.TYPE_STORED));
				doc.add(new Field("photoPath", photoUpload_A + fileBNameNew, TextField.TYPE_STORED));
				doc.add(new Field("partId", partId.toString(), TextField.TYPE_STORED));
				doc.add(new Field("level", "1", TextField.TYPE_STORED));
				doc.add(new Field("msg", msg, TextField.TYPE_STORED));
				try {
					iWriterA.addDocument(doc);
					iWriterAll.addDocument(doc);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				accessory.setPartId(partId);
				accessory.setMsg(msg);
				accessory.setLevel(level);
				accessory.setAccessoryImg(photoUpload_A + fileBNameNew);
				accessoryRepository.save(accessory);
				try {
					iWriter.close();
					iWriterA.close();
					iWriterAll.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				InputStream is = null;
				OutputStream os = null;
				File oldFile = null;
				if (mf != null && !mf.isEmpty()) {
					try {
						oldFile = new File(accessory.getAccessoryImg());
						os = new FileOutputStream(oldFile);
						is = mf.getInputStream();
						oldFile.delete();
						oldFile.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						resizeImage(is, os, 300, "JPG");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	@Override
	public void savePictureToB(String partId) {
		File photoUploadFile = new File(photoUpload_B);
		String[] fileNames = photoUploadFile.list();
		File fromPhoto = null;
		File toPhoto = null;
		Date date = new Date();
		Date fromDt = TimeUtils.getStartTimeOfMonth(date);
		Date toDt = TimeUtils.getEndTimeOfMonth(date);
		Integer s = accessoryRepository.countByMonth(fromDt, toDt);
		String fileNameNew = null;
		for (int i = 0; i < fileNames.length; i++) {
			if (fileNames[i].equals(".DS_Store")) {

			} else {
				fromPhoto = new File(photoUpload_B + fileNames[i]);
				toPhoto = new File(rootPath + fileNames[i]);
				int l = 1;
				fileNameNew = fileNames[i];
				while (toPhoto.exists()) {
					fileNameNew = fileNames[i].split("\\.")[0] + "_" + l + "." + fileNames[i].split("\\.")[1];
					toPhoto = new File(rootPath + fileNameNew);
					l++;
				}
				try {
					toPhoto.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				OutputStream fs;
				InputStream inStream;
				Accessory accessory = new Accessory();
				try {
					inStream = new FileInputStream(fromPhoto); // 读入原文件
					fs = new FileOutputStream(toPhoto);
					resizeImage(inStream, fs, 900, "JPG");
					inStream.close();
					fromPhoto.delete();
					accessory.setAccessoryName(fileNameNew.split("\\.")[0]);
					accessory.setCreDt(date);
					accessory.setAccessoryImg(rootPath + fileNameNew);
					accessory.setAccessoryNum(AddZeroUtil.addZero(s + i + 1, 8));
					accessory.setLevel("2");
					accessory.setModelId(1);
					accessory.setPartId(Integer.valueOf(partId));
					accessory.setStyleId(1);
					accessoryRepository.save(accessory);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Analyzer analyzer = new StandardAnalyzer();
				Directory directory = null;
				Directory dirA = null;
				Directory dirAll = null;
				IndexWriter iWriter = null;
				IndexWriter iWriterAll = null;
				try {
					dirAll = FSDirectory.open(Paths.get(indexpathAll));
					directory = FSDirectory.open(Paths.get(indexpath));
					dirA = FSDirectory.open(Paths.get(indexpathA));
					IndexWriterConfig config = new IndexWriterConfig(analyzer);
					IndexWriterConfig configAll = new IndexWriterConfig(analyzer);
					iWriter = new IndexWriter(directory, config);
					iWriterAll = new IndexWriter(dirAll, configAll);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Document doc = new Document();
				doc.add(new Field("fileName", fileNameNew.split("\\.")[0], TextField.TYPE_STORED));
				doc.add(new Field("photoId", accessory.getAccessoryNum(), TextField.TYPE_STORED));
				doc.add(new Field("creDt", TimeUtils.datetimeToStr(date), TextField.TYPE_STORED));
				doc.add(new Field("photoPath", rootPath + fileNameNew, TextField.TYPE_STORED));
				doc.add(new Field("partId", partId, TextField.TYPE_STORED));
				doc.add(new Field("level", "2", TextField.TYPE_STORED));
				doc.add(new Field("msg", "无备注", TextField.TYPE_STORED));
				try {
					iWriter.addDocument(doc);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					iWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if (dirAll.listAll() != null && dirAll.listAll().length != 1) {
						iWriterAll.deleteAll();
					}
					if (directory.listAll() != null && directory.listAll().length != 0) {
						iWriterAll.addIndexes(directory);
					}
					if (dirA.listAll() != null && dirA.listAll().length != 0 && dirA.listAll().length != 2
							&& dirA.listAll().length != 1) {
						iWriterAll.addIndexes(dirA);
					}
					iWriterAll.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public LucenePage luceneInA(String key, Integer page) throws IOException, ParseException {
		Analyzer analyzer = new StandardAnalyzer();
		Directory directory = FSDirectory.open(Paths.get(indexpathA));
		DirectoryReader iReader = DirectoryReader.open(directory);
		IndexSearcher iSearcher = new IndexSearcher(iReader);
		String[] multiFields = { "fileName", "photoId" };
		MultiFieldQueryParser parser = new MultiFieldQueryParser(multiFields, analyzer);
		Query query = parser.parse(key);
		TopDocs docs = null;
		Integer count = null;
		if (page != null && page == 1) {
			docs = iSearcher.search(query, 16);
		} else {
			docs = iSearcher.search(query, 16 * (page - 1));
			ScoreDoc[] hits = docs.scoreDocs;
			docs = iSearcher.searchAfter(hits[hits.length - 1], query, 16);
		}
		count = iSearcher.count(query);
		ScoreDoc[] hits = docs.scoreDocs;
		// docs = iSearcher.searchAfter(hits[hits.length - 1], query, 2);
		// hits = docs.scoreDocs;
		System.out.println(count);
		System.out.println(hits.length);

		// SimpleHTMLFormatter simpleHTMLFormatter = new
		// SimpleHTMLFormatter("<span style='color:green'>", "</span>");
		// Highlighter highlighter = new Highlighter(simpleHTMLFormatter, new
		// QueryScorer(query));
		// highlighter.setTextFragmenter(new SimpleFragmenter(100));
		System.out.println("Searched " + hits.length + " documents.");
		// Iteratethrough the results:
		List<LuceneOutput> luceneOutputs = new ArrayList<LuceneOutput>();
		LuceneOutput luceneOutput = null;
		for (int i = 0; i < hits.length; i++) {
			Document hitDoc = iSearcher.doc(hits[i].doc);
			String[] scoreExplain = null;
			// scoreExplain可以显示文档的得分详情，这里用split截取总分
			scoreExplain = iSearcher.explain(query, hits[i].doc).toString().split(" ", 2);
			String scores = scoreExplain[0];
			// assertEquals("Thisis the text to be indexed.",
			// hitDoc.get("fieldname"));
			System.out.println("score:" + scores);
			String value = hitDoc.get("fileName");
			String id = hitDoc.get("photoId");
			String photoPath = hitDoc.get("photoPath");
			String partId = hitDoc.get("partId");
			String level = hitDoc.get("level");
			String msg = hitDoc.get("msg");
			luceneOutput = new LuceneOutput(value, id, GetImageStr(photoPath), partId, level, msg);
			luceneOutputs.add(luceneOutput);
			// TokenStream tokenStream = analyzer.tokenStream(value, new
			// StringReader(value));
			// String str1 = highlighter.getBestFragment(tokenStream, value);

			System.out.println(value);
			System.out.println(id);
		}
		LucenePage lucenePage = new LucenePage();
		lucenePage.setContent(luceneOutputs);
		lucenePage.setSize(hits.length);
		lucenePage.setTotalElements(count);
		if (hits.length == 0) {
			lucenePage.setPage(page);
		} else {
			lucenePage.setPage(page);
		}
		iReader.close();
		directory.close();
		return lucenePage;
	}

	public LucenePage luceneInB(String key, Integer page) throws IOException, ParseException {
		Analyzer analyzer = new StandardAnalyzer();
		Directory directory = FSDirectory.open(Paths.get(indexpath));
		DirectoryReader iReader = DirectoryReader.open(directory);
		IndexSearcher iSearcher = new IndexSearcher(iReader);
		String[] multiFields = { "fileName", "photoId" };
		MultiFieldQueryParser parser = new MultiFieldQueryParser(multiFields, analyzer);
		Query query = parser.parse(key);
		TopDocs docs = null;
		Integer count = null;
		if (page != null && page == 1) {
			docs = iSearcher.search(query, 16);
		} else {
			docs = iSearcher.search(query, 16 * (page - 1));
			ScoreDoc[] hits = docs.scoreDocs;
			docs = iSearcher.searchAfter(hits[hits.length - 1], query, 16);
		}
		count = iSearcher.count(query);
		ScoreDoc[] hits = docs.scoreDocs;
		// docs = iSearcher.searchAfter(hits[hits.length - 1], query, 2);
		// hits = docs.scoreDocs;
		System.out.println(count);
		System.out.println(hits.length);

		// SimpleHTMLFormatter simpleHTMLFormatter = new
		// SimpleHTMLFormatter("<span style='color:green'>", "</span>");
		// Highlighter highlighter = new Highlighter(simpleHTMLFormatter, new
		// QueryScorer(query));
		// highlighter.setTextFragmenter(new SimpleFragmenter(100));
		System.out.println("Searched " + hits.length + " documents.");
		// Iteratethrough the results:
		List<LuceneOutput> luceneOutputs = new ArrayList<LuceneOutput>();
		LuceneOutput luceneOutput = null;
		for (int i = 0; i < hits.length; i++) {
			Document hitDoc = iSearcher.doc(hits[i].doc);
			String[] scoreExplain = null;
			// scoreExplain可以显示文档的得分详情，这里用split截取总分
			scoreExplain = iSearcher.explain(query, hits[i].doc).toString().split(" ", 2);
			String scores = scoreExplain[0];
			// assertEquals("Thisis the text to be indexed.",
			// hitDoc.get("fieldname"));
			System.out.println("score:" + scores);
			String value = hitDoc.get("fileName");
			String id = hitDoc.get("photoId");
			String photoPath = hitDoc.get("photoPath");
			String partId = hitDoc.get("partId");
			String level = hitDoc.get("level");
			String msg = hitDoc.get("msg");
			System.out.println(photoPath);
			try {
				luceneOutput = new LuceneOutput(value, id, GetImageStr(photoPath), partId, level, msg);
			} catch (Exception e) {
				System.out.println(photoPath);
				return null;
			}
			luceneOutputs.add(luceneOutput);
			// TokenStream tokenStream = analyzer.tokenStream(value, new
			// StringReader(value));
			// String str1 = highlighter.getBestFragment(tokenStream, value);

			System.out.println(value);
			System.out.println(id);
		}
		LucenePage lucenePage = new LucenePage();
		lucenePage.setContent(luceneOutputs);
		lucenePage.setSize(hits.length);
		lucenePage.setTotalElements(count);
		if (hits.length == 0) {
			lucenePage.setPage(0);
		} else {
			lucenePage.setPage(count / hits.length);
		}
		iReader.close();
		directory.close();
		return lucenePage;
	}

	@Override
	public LucenePage luceneInAll(String key, Integer page) throws IOException, ParseException {
		Analyzer analyzer = new StandardAnalyzer();
		Directory directory = FSDirectory.open(Paths.get(indexpathAll));
		DirectoryReader iReader = DirectoryReader.open(directory);
		IndexSearcher iSearcher = new IndexSearcher(iReader);
		String[] multiFields = { "fileName", "photoId" };
		MultiFieldQueryParser parser = new MultiFieldQueryParser(multiFields, analyzer);
		Query query = parser.parse(key);
		TopDocs docs = null;
		Integer count = null;
		if (page != null && page == 0) {
			docs = iSearcher.search(query, 16);
		} else {
			docs = iSearcher.search(query, 16 * page);
			ScoreDoc[] hits = docs.scoreDocs;
			docs = iSearcher.searchAfter(hits[hits.length - 1], query, 16);
		}
		count = iSearcher.count(query);
		ScoreDoc[] hits = docs.scoreDocs;
		// docs = iSearcher.searchAfter(hits[hits.length - 1], query, 2);
		// hits = docs.scoreDocs;
		System.out.println(count);
		System.out.println(hits.length);

		// SimpleHTMLFormatter simpleHTMLFormatter = new
		// SimpleHTMLFormatter("<span style='color:green'>", "</span>");
		// Highlighter highlighter = new Highlighter(simpleHTMLFormatter, new
		// QueryScorer(query));
		// highlighter.setTextFragmenter(new SimpleFragmenter(100));
		System.out.println("Searched " + hits.length + " documents.");
		// Iteratethrough the results:
		List<LuceneOutput> luceneOutputs = new ArrayList<LuceneOutput>();
		LuceneOutput luceneOutput = null;
		for (int i = 0; i < hits.length; i++) {
			Document hitDoc = iSearcher.doc(hits[i].doc);
			String[] scoreExplain = null;
			// scoreExplain可以显示文档的得分详情，这里用split截取总分
			scoreExplain = iSearcher.explain(query, hits[i].doc).toString().split(" ", 2);
			String scores = scoreExplain[0];
			// assertEquals("Thisis the text to be indexed.",
			// hitDoc.get("fieldname"));
			System.out.println("score:" + scores);
			String value = hitDoc.get("fileName");
			String id = hitDoc.get("photoId");
			String photoPath = hitDoc.get("photoPath");
			String partId = hitDoc.get("partId");
			String level = hitDoc.get("level");
			String msg = hitDoc.get("msg");
			luceneOutput = new LuceneOutput(value, id, GetImageStr(photoPath), partId, level, msg);
			luceneOutputs.add(luceneOutput);
			// TokenStream tokenStream = analyzer.tokenStream(value, new
			// StringReader(value));
			// String str1 = highlighter.getBestFragment(tokenStream, value);

			System.out.println(value);
			System.out.println(id);
		}
		LucenePage lucenePage = new LucenePage();
		lucenePage.setContent(luceneOutputs);
		lucenePage.setSize(hits.length);
		lucenePage.setTotalElements(count);
		if (hits.length == 0) {
			lucenePage.setPage(0);
		} else {
			lucenePage.setPage(count / hits.length);
		}
		iReader.close();
		directory.close();
		return lucenePage;
	}

	@Override
	public List<Accessory> modifyList(String[] nums) {
		List<Accessory> accessories = new ArrayList<Accessory>();
		Accessory accessory = null;
		for (int i = 0; i < nums.length; i++) {
			accessory = new Accessory();
			accessory = accessoryRepository.findOneByNum(nums[i]);
			accessory.setAccessoryImg(GetImageStr(accessory.getAccessoryImg()));
			accessories.add(accessory);
		}
		return accessories;
	}

	@Override
	public SaleHistoryOutput findByWeek(Date centerDate, Integer isNext) {
		Date fromDt = null;
		Date toDt = null;
		SaleHistoryOutput output = null;
		if (isNext == 0) {
			fromDt = TimeUtils.getFirstDayOfWeek(centerDate);
			toDt = TimeUtils.getLastDayOfWeek(centerDate);
			output = initOutput(fromDt);
		} else if (isNext == -1) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(centerDate);
			cal.add(Calendar.DAY_OF_MONTH, -7);
			fromDt = TimeUtils.getFirstDayOfWeek(cal.getTime());
			toDt = TimeUtils.getLastDayOfWeek(cal.getTime());
			output = initOutput(fromDt);
		} else if (isNext == 1) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(centerDate);
			cal.add(Calendar.DAY_OF_MONTH, 7);
			fromDt = TimeUtils.getFirstDayOfWeek(cal.getTime());
			toDt = TimeUtils.getLastDayOfWeek(cal.getTime());
			output = initOutput(fromDt);
		}
		output.setAccessories(accessoryRepository.findSaleByWeek(fromDt, toDt));
		output.setInAccessories(accessoryRepository.findInByWeek(fromDt, toDt));
		Iterator<Accessory> it = output.getAccessories().iterator();
		while (it.hasNext()) {
			Date date = it.next().getSaleDt();
			int index = (int) ((date.getTime() - fromDt.getTime()) / (1000 * 60 * 60 * 24));
			output.getNum()[index] = output.getNum()[index] + 1;
		}
		Iterator<Accessory> it2 = output.getInAccessories().iterator();
		while (it2.hasNext()) {
			Date date = it2.next().getCreDt();
			int index = (int) ((date.getTime() - fromDt.getTime()) / (1000 * 60 * 60 * 24));
			output.getInNum()[index] = output.getInNum()[index] + 1;
		}
		return output;
	}

	private SaleHistoryOutput initOutput(Date fromDt) {
		SaleHistoryOutput output = new SaleHistoryOutput();
		Calendar cal = Calendar.getInstance();
		cal.setTime(fromDt);
		for (int i = 0; i < 7; i++) {
			output.getDays()[i] = TimeUtils.dateToStr(cal.getTime());
			cal.add(Calendar.DAY_OF_MONTH, 1);
		}
		return output;
	}

	@Override
	public SaleHistoryOutput findBByWeek(Date centerDate, Integer isNext) {
		Date fromDt = null;
		Date toDt = null;
		SaleHistoryOutput output = null;
		if (isNext == 0) {
			fromDt = TimeUtils.getFirstDayOfWeek(centerDate);
			toDt = TimeUtils.getLastDayOfWeek(centerDate);
			output = initOutput(fromDt);
		} else if (isNext == -1) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(centerDate);
			cal.add(Calendar.DAY_OF_MONTH, -7);
			fromDt = TimeUtils.getFirstDayOfWeek(cal.getTime());
			toDt = TimeUtils.getLastDayOfWeek(cal.getTime());
			output = initOutput(fromDt);
		} else if (isNext == 1) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(centerDate);
			cal.add(Calendar.DAY_OF_MONTH, 7);
			fromDt = TimeUtils.getFirstDayOfWeek(cal.getTime());
			toDt = TimeUtils.getLastDayOfWeek(cal.getTime());
			output = initOutput(fromDt);
		}
		output.setAccessories(accessoryRepository.findSaleBByWeek(fromDt, toDt));
		output.setInAccessories(accessoryRepository.findInBByWeek(fromDt, toDt));
		Iterator<Accessory> it = output.getAccessories().iterator();
		while (it.hasNext()) {
			Date date = it.next().getSaleDt();
			int index = (int) ((date.getTime() - fromDt.getTime()) / (1000 * 60 * 60 * 24));
			output.getNum()[index] = output.getNum()[index] + 1;
		}
		Iterator<Accessory> it2 = output.getInAccessories().iterator();
		while (it2.hasNext()) {
			Date date = it2.next().getCreDt();
			int index = (int) ((date.getTime() - fromDt.getTime()) / (1000 * 60 * 60 * 24));
			output.getInNum()[index] = output.getInNum()[index] + 1;
		}
		return output;
	}

	@Override
	public Integer[] stockB() {
		Integer unfix = accessoryRepository.findByPartId(1, "2");
		Integer fixing = accessoryRepository.findByPartId(2, "2");
		Integer fixed = accessoryRepository.findByPartId(3, "2");
		Integer[] status = {unfix, fixing, fixed};
		return status;
	}
}
