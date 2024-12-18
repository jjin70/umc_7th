package umc.spring.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.spring.domain.Member;
import umc.spring.domain.enums.MemberStatus;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByNameAndStatus(String name, MemberStatus status);

//    @Query("SELECT m FROM Member m WHERE m.name = :name AND m.status = :status")
//    List<Member> findByNameAndStatus(@Param("name") String name, @Param("status") MemberStatus status);

    Optional<Member> findByEmail(String email);
}
