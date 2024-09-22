//package mk.ukim.finki.emt.airbnb.repository;
//
//import jakarta.transaction.Transactional;
//import mk.ukim.finki.emt.airbnb.models.views.HostView;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface HostViewRepository extends JpaRepository<HostView, String> {
//
//
//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query(value = "REFRESH MATERIALIZED VIEW public.host_view", nativeQuery = true)
//    void refreshMaterializedView();
//
//}
