package com.saendino.demo.cmm.mapper;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;

public class CommAbstractMapper {
	/**
	 * Annotation 형식으로 sqlSession(SqlSessionFactoryBean)을 받아와
	 * 이를 super(SqlSessionDaoSupport)의 setSqlSessionFactory 메서드를 호출하여 설정해 준다.
	 * <p>
	 * SqlSessionTemplate이 지정된 경우된 경우 이 SqlSessionFactory가 무시된다. (Batch 처리를 위해서는 SqlSessionTemplate가 필요)
	 * </p>
	 *
	 * @param sqlSession SqlSessionFactory로 MyBatis와의 연계를 위한 기본 클래스
	 */
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
//		super.setSqlSessionFactory(sqlSession);
	}
}
