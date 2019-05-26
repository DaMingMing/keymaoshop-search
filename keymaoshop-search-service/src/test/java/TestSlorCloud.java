import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class TestSlorCloud {

    @Test
    public void testSolrCloudAddDocument() throws Exception {
        // 第一步：把solrJ相关的jar包添加到工程中。
        // 第二步：创建一个SolrServer对象，需要使用CloudSolrServer子类。构造方法的参数是zookeeper的地址列表。
        //参数是zookeeper的地址列表，使用逗号分隔
        CloudSolrServer solrServer = new CloudSolrServer("192.168.27.101:2181,192.168.27.102:2181,192.168.27.103:2181");
        // 第三步：需要设置DefaultCollection属性。
        solrServer.setDefaultCollection("collection2");
        // 第四步：创建一SolrInputDocument对象。
        SolrInputDocument document = new SolrInputDocument();
        // 第五步：向文档对象中添加域
        document.addField("item_title", "测试商品");
        document.addField("item_price", "100");
        document.addField("id", "test001");
        // 第六步：把文档对象写入索引库。
        solrServer.add(document);
        // 第七步：提交。
        solrServer.commit();

    }

    @Test
    public void queryIndex() throws Exception {
        // 第一步：把solrJ相关的jar包添加到工程中。
        // 第二步：创建一个SolrServer对象，需要使用CloudSolrServer子类。构造方法的参数是zookeeper的地址列表。
        //参数是zookeeper的地址列表，使用逗号分隔
        CloudSolrServer solrServer = new CloudSolrServer("192.168.27.101:2181,192.168.27.102:2181,192.168.27.103:2181");
        // 第三步：需要设置DefaultCollection属性。
        solrServer.setDefaultCollection("collection2");
        //创建一个SolrQuery对象。
        SolrQuery query = new SolrQuery();
        query.set("q", "*:*");
        //执行查询，QueryResponse对象。
        QueryResponse queryResponse = solrServer.query(query);
        //取文档列表。取查询结果的总记录数
        SolrDocumentList solrDocumentList = queryResponse.getResults();
        System.out.println("查询结果总记录数：" + solrDocumentList.getNumFound());
        //遍历文档列表，从取域的内容。
        for (SolrDocument solrDocument : solrDocumentList) {
            System.out.println(solrDocument.get("id"));
            System.out.println(solrDocument.get("item_title"));
            System.out.println(solrDocument.get("item_sell_point"));
            System.out.println(solrDocument.get("item_price"));
            System.out.println(solrDocument.get("item_image"));
            System.out.println(solrDocument.get("item_category_name"));
        }
    }

}
