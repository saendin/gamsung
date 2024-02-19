//package com.saendino.demo.cmm.mapper;
//
//import java.util.List;
//import java.util.Map;
//
//import org.apache.ibatis.annotations.Mapper;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//
//@Mapper
//public class CommDAO {
//
//	@Autowired
//	private SqlSessionTemplate sqlSession;
//	
//	public Map<?,?> selectData(String queryId, Object param) {
//		return sqlSession.selectOne(queryId, param);
//	}
//	
//	public List<?> selectListData(String queryId, Object param) {
//		return sqlSession.selectList(queryId, param);
//	}
//	
//	public int insertData(String queryId, Object param) {
//		return sqlSession.insert(queryId, param);
//	}
//	
//	public int updateData(String queryId, Object param) {
//		return sqlSession.update(queryId, param);
//	}
//	
//	public int deleteData(String queryId, Object param) {
//		return sqlSession.delete(queryId,param);
//	}
//}
