package com.sample;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.builder.Results;
import org.kie.api.builder.model.KieBaseModel;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


/**
 * This is a sample file to launch a rule package from a rule source file.
 */
public class DroolsTest {
	
	// KieContainer 설정 
	private static final String G = "com.sample";
	private static final String A = "Drools2ndDay";
	private static final String V = "1.0.0-SNAPSHOT";

	
	public static final void main(String[] args) {
		try {
						
			// KieService 생성 
			KieServices kService = KieServices.Factory.get(); 
	
			// KieContainer 생성  
			ReleaseId rel1 = kService.newReleaseId(G, A, V);
			KieContainer kContainer = kService.newKieContainer(rel1); 
			
			// KieBase와 KieSession 생성 
			KieBase kBase = kContainer.getKieBase("rules");
			KieSession kSession = kBase.newKieSession();

			// KieScanner 생성 - 3초에 한번씩 변경여부 체
			KieScanner kScanner = kService.newKieScanner(kContainer);
			kScanner.start(3000L);

			// 테스트를 위한 루프 
			while(true){

				// 멤버 생성 
				Member memFact1 = new Member("Jang", "HR", 178);
				Member memFact2 = new Member("Lee", "HR", 170);
				Member memFact3 = new Member("Shin", "HR", 165);
				Member memFact4 = new Member("Jung", "HR", 174);
	
				//멤버 working memory에 삽입 
				kSession.insert(memFact1);
				kSession.insert(memFact2);
				kSession.insert(memFact3);
				kSession.insert(memFact4);
		
				// Rule engine 구동 
				kSession.fireAllRules();		
				
				// 5초 마다 해당 루프 다시 수행 
				Thread.sleep(5000);			
			}
			

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
