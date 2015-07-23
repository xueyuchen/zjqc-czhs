package co.bohc.diet.domain.service.accessory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

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

import sun.misc.BASE64Decoder;
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

    private static String indexpath = "D:\\luceneIndex";
    
    private static String rootPath = "E:\\project\\czxsxt\\html\\image\\img\\zp";
    
    private static String photoUpload = "C:\\fileUpload";

    @Override
    public List<Accessory> findByModelStylePart(String modelName, String styleName, String partName) {
        List<Accessory> accessories = accessoryRepository.findByModelStylePart(modelName, styleName, partName);
        for (int i = 0; i < accessories.size(); i++) {
            accessories.get(i).setModel(null);
            accessories.get(i).setPart(null);
            accessories.get(i).setStyle(null);
        }
        return accessories;
    }

    @Override
    public List<Accessory> findByCreDt() {
        List<Accessory> accessories = accessoryRepository.findByCreDt();
        for (int i = 0; i < accessories.size(); i++) {
            accessories.get(i).setModel(null);
            accessories.get(i).setPart(null);
            accessories.get(i).setStyle(null);
        }
        return accessories;
    }

    @Override
    public void saveAccessory(String level, Integer modelId, Integer styleId, Integer partId, String imgDataUrl) {
        String accessoryImg = generateImage(modelId, styleId, partId, imgDataUrl);
        Model model = modelRepository.findOne(modelId);
        Style style = styleRepository.findOne(styleId);
        Part part = partRepository.findOne(partId);
        String accessoryName = model.getBrand().getBrandName() + " " + model.getModelName() + " "
                + style.getStyleName() + " " + part.getPartName();
        Accessory accessory = new Accessory();
        accessory.setAccessoryImg(accessoryImg);
        accessory.setAccessoryName(accessoryName);
        accessory.setAccessoryNum(getImgName(modelId, styleId, partId));
        accessory.setCreDt(new Date());
        accessory.setModel(model);
        accessory.setPart(part);
        accessory.setStyle(style);
        accessory.setLevel(level);
        accessoryRepository.save(accessory);

    }

    public String generateImage(Integer modelId, Integer styleId, Integer partId, String imgDataUrl) { // 对字节数组字符串进行Base64解码并生成图片
        String modelIdStr = String.valueOf(modelId);
        String styleIdStr = String.valueOf(styleId);
        String partIdStr = String.valueOf(partId);
        if (imgDataUrl == null) // 图像数据为空
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        imgDataUrl = imgDataUrl.split(",")[1];
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgDataUrl);
            // for(int i=0;i<b.length;++i)
            // {
            // if(b[i]<0)
            // {//调整异常数据
            // b[i]+=256;
            // }
            // }
            // 生成jpeg图片
            String imgName = "image/img/" + modelIdStr + "/" + styleIdStr + "/" + partIdStr + "/"
                    + getImgName(modelId, styleId, partId) + ".jpg";
            File pageElementFileDir = new File("c://project//czxsxt//html//image//img//" + modelIdStr + "//"
                    + styleIdStr + "//" + partIdStr);
            if (!pageElementFileDir.exists()) {
                pageElementFileDir.mkdirs();
            }
            String imgFilePath = "c://project//czxsxt//html//image//img//" + modelIdStr + "//" + styleIdStr + "//"
                    + partIdStr + "//" + getImgName(modelId, styleId, partId) + ".jpg";// 新生成的图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return imgName;
        } catch (Exception e) {
            return null;
        }
    }

    private String getImgName(Integer modelId, Integer styleId, Integer partId) {
        Integer count = accessoryRepository.findCountByMSP(modelId, styleId, partId);
        if (count == null) {
            count = 0;
        } else {
            count = count + 1;
        }
        String modelIdStr = String.valueOf(modelId);
        String styleIdStr = String.valueOf(styleId);
        String partIdStr = String.valueOf(partId);
        String countNumStr = String.valueOf(count);
        if (modelIdStr.length() == 1) {
            modelIdStr = "00" + modelIdStr;
        } else if (modelIdStr.length() == 2) {
            modelIdStr = "0" + modelIdStr;
        }
        if (styleIdStr.length() == 1) {
            styleIdStr = "0" + styleIdStr;
            // } else if (styleIdStr.length() == 2) {
            // styleIdStr = "0" + styleIdStr;
        }
        if (partIdStr.length() == 1) {
            partIdStr = "00" + partIdStr;
        } else if (partIdStr.length() == 2) {
            partIdStr = "0" + partIdStr;
        }
        Integer zeroNum = 5 - countNumStr.length();
        for (int i = 0; i < zeroNum; i++) {
            countNumStr = "0" + countNumStr;
        }
        return modelIdStr + styleIdStr + partIdStr + countNumStr;
    }

    @Override
    public Page<Accessory> findByBrandId(Integer brandId, Pageable pageable) {
        List<Accessory> accessories = accessoryRepository.findByBrandId(brandId, pageable);
        Integer count = accessoryRepository.countByBrandId(brandId);
        Page<Accessory> page = new PageImpl<Accessory>(accessories, pageable, count);
        if (accessories == null) {
            return null;
        }
        for (int i = 0; i < accessories.size(); i++) {
            accessories.get(i).setModel(null);
            accessories.get(i).setPart(null);
            accessories.get(i).setStyle(null);
        }
        return page;
    }

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

    @Override
    public List<Accessory> findByBrandIdSale(Integer brandId) {
        List<Accessory> accessories = null;
        if (brandId == null) {
            accessories = accessoryRepository.findByCreDtSale();
        } else {
            accessories = accessoryRepository.findByBrandIdAndSale(brandId);
        }
        if (accessories == null) {
            return null;
        }
        for (int i = 0; i < accessories.size(); i++) {
            accessories.get(i).setModel(null);
            accessories.get(i).setPart(null);
            accessories.get(i).setStyle(null);
        }
        return accessories;
    }

    @Override
    public List<Accessory> findByBrandIdAndSale(Integer brandId) {
        List<Accessory> accessories = accessoryRepository.findByBrandIdAndSale(brandId);
        if (accessories == null) {
            return null;
        }
        for (int i = 0; i < accessories.size(); i++) {
            accessories.get(i).setModel(null);
            accessories.get(i).setPart(null);
            accessories.get(i).setStyle(null);
        }
        return accessories;
    }

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
    public LucenePage SearchByLucene(String key) {
        try {
            return lucene(key);
        } catch (IOException | ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    private LucenePage lucene(String key) throws IOException, ParseException{
        Analyzer analyzer = new StandardAnalyzer();
        Directory directory = FSDirectory.open(Paths.get(indexpath));
        DirectoryReader iReader = DirectoryReader.open(directory);
        IndexSearcher iSearcher = new IndexSearcher(iReader);
        String[] multiFields = { "fileName", "photoId", "photoPath" };
        MultiFieldQueryParser parser = new MultiFieldQueryParser(multiFields, analyzer);
        Query query = parser.parse(key);
        TopDocs docs = iSearcher.search(query, 10);
        Integer count = iSearcher.count(query);
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
            luceneOutput = new LuceneOutput(value, id, photoPath);
            luceneOutputs.add(luceneOutput);
//            TokenStream tokenStream = analyzer.tokenStream(value, new StringReader(value));
            // String str1 = highlighter.getBestFragment(tokenStream, value);

            System.out.println(value);
            System.out.println(id);
        }
        LucenePage page = new LucenePage();
        page.setContent(luceneOutputs);
        page.setSize(hits.length);
        page.setTotalElements(count);
        page.setPage(count/hits.length);
        iReader.close();
        directory.close();
        return page;
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
        String rootPath = photoUpload;
        File rootFile = new File(rootPath);
        String[] photos = rootFile.list();
        Document doc = null;
        for (int i = 0; i < photos.length; i++) {
            String photoName = photos[i].toString().split("\\.")[0];
            doc = new Document();
            doc.add(new Field("fileName", photoName, TextField.TYPE_STORED));
            doc.add(new Field("photoId", "123", TextField.TYPE_STORED));
            doc.add(new Field("photoPath", "image/img/zp/" + photos[i].toString(), TextField.TYPE_STORED));
            try {
                iWriter.addDocument(doc);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            iWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
