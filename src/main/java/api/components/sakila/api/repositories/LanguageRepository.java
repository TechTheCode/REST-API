package api.components.sakila.api.repositories;

import api.components.sakila.api.domain.Language;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LanguageRepository extends JpaRepository<Language, Byte> {

}
