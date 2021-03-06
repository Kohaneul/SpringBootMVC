package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
* 실무에서는 동시성 문제가 고려되어있지 않기 때문에 ConcurrentHashMap, AtomicLong 사용 고려
*
* */



public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance= new MemberRepository();  //싱글톤으로 생성

    public static MemberRepository getInstance(){
        return instance;
    }
    //싱글톤일때는 private로 생성자 설정하여 아무나 생성하지 못하도록 막아줌
    private MemberRepository(){

    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }


    public void clearStore(){
        store.clear();
    }

}
