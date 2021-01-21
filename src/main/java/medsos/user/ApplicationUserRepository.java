package medsos.user;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApplicationUserRepository extends MongoRepository<ApplicationUser, Long> {
    public ApplicationUser findByUsername(String username);
}