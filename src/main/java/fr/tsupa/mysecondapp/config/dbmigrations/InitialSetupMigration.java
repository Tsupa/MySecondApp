package fr.tsupa.mysecondapp.config.dbmigrations;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;

import fr.tsupa.mysecondapp.domain.Authority;
import fr.tsupa.mysecondapp.domain.Category;
import fr.tsupa.mysecondapp.domain.Item;
import fr.tsupa.mysecondapp.domain.Type;
import fr.tsupa.mysecondapp.domain.User;
import fr.tsupa.mysecondapp.security.AuthoritiesConstants;

/**
 * Creates the initial database setup
 */
@ChangeLog(order = "001")
public class InitialSetupMigration {

	@ChangeSet(order = "01", author = "initiator", id = "01-addAuthorities")
	public void addAuthorities(MongoTemplate mongoTemplate) {
		Authority adminAuthority = new Authority();
		adminAuthority.setName(AuthoritiesConstants.ADMIN);
		Authority userAuthority = new Authority();
		userAuthority.setName(AuthoritiesConstants.USER);
		mongoTemplate.save(adminAuthority);
		mongoTemplate.save(userAuthority);
	}

	@ChangeSet(order = "02", author = "initiator", id = "02-addUsers")
	public void addUsers(MongoTemplate mongoTemplate) {
		Authority adminAuthority = new Authority();
		adminAuthority.setName(AuthoritiesConstants.ADMIN);
		Authority userAuthority = new Authority();
		userAuthority.setName(AuthoritiesConstants.USER);

		User systemUser = new User();
		systemUser.setId("user-0");
		systemUser.setLogin("system");
		systemUser.setPassword(
				"$2a$10$mE.qmcV0mFU5NcKh73TZx.z4ueI/.bDWbj0T1BYyqP481kGGarKLG");
		systemUser.setFirstName("");
		systemUser.setLastName("System");
		systemUser.setEmail("system@localhost");
		systemUser.setActivated(true);
		systemUser.setLangKey("en");
		systemUser.setCreatedBy(systemUser.getLogin());
		systemUser.setCreatedDate(Instant.now());
		systemUser.getAuthorities().add(adminAuthority);
		systemUser.getAuthorities().add(userAuthority);
		mongoTemplate.save(systemUser);

		User anonymousUser = new User();
		anonymousUser.setId("user-1");
		anonymousUser.setLogin("anonymoususer");
		anonymousUser.setPassword(
				"$2a$10$j8S5d7Sr7.8VTOYNviDPOeWX8KcYILUVJBsYV83Y5NtECayypx9lO");
		anonymousUser.setFirstName("Anonymous");
		anonymousUser.setLastName("User");
		anonymousUser.setEmail("anonymous@localhost");
		anonymousUser.setActivated(true);
		anonymousUser.setLangKey("en");
		anonymousUser.setCreatedBy(systemUser.getLogin());
		anonymousUser.setCreatedDate(Instant.now());
		mongoTemplate.save(anonymousUser);

		User adminUser = new User();
		adminUser.setId("user-2");
		adminUser.setLogin("admin");
		adminUser.setPassword(
				"$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC");
		adminUser.setFirstName("admin");
		adminUser.setLastName("Administrator");
		adminUser.setEmail("admin@localhost");
		adminUser.setActivated(true);
		adminUser.setLangKey("en");
		adminUser.setCreatedBy(systemUser.getLogin());
		adminUser.setCreatedDate(Instant.now());
		adminUser.getAuthorities().add(adminAuthority);
		adminUser.getAuthorities().add(userAuthority);
		mongoTemplate.save(adminUser);

		User userUser = new User();
		userUser.setId("user-3");
		userUser.setLogin("user");
		userUser.setPassword(
				"$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K");
		userUser.setFirstName("");
		userUser.setLastName("User");
		userUser.setEmail("user@localhost");
		userUser.setActivated(true);
		userUser.setLangKey("en");
		userUser.setCreatedBy(systemUser.getLogin());
		userUser.setCreatedDate(Instant.now());
		userUser.getAuthorities().add(userAuthority);
		mongoTemplate.save(userUser);
	}

	@ChangeSet(order = "03", author = "initiator", id = "03-addItems")
	public void addItems(MongoTemplate mongoTemplate) {
		List<Type> types = getTypes();
		Set<Category> categories = getCategories();

		Item item = new Item();
		item.setId("item-1");
		item.setName("name-item1");
		item.setDescription("description1");
		item.setActive(true);
		item.setNumber(1);
		item.setDuration(10);
		item.setCreatedBy("system");
		item.setCreatedDate(Instant.now());
		item.setType(types.get(0));
		item.setCategories(
				categories.stream().limit(2).collect(Collectors.toSet()));
		mongoTemplate.save(item);

	}

	@ChangeSet(order = "04", author = "initiator", id = "04-addTypes")
	public void addTypes(MongoTemplate mongoTemplate) {
		List<Type> types = getTypes();

		types.forEach(type -> {
			mongoTemplate.save(type);
		});
	}

	@ChangeSet(order = "05", author = "initiator", id = "05-addCategories")
	public void addCategories(MongoTemplate mongoTemplate) {
		Set<Category> categories = getCategories();

		categories.forEach(category -> {
			mongoTemplate.save(category);
		});
	}

	private List<Type> getTypes() {
		List<Type> types = new ArrayList<>();
		Type type1 = new Type();
		type1.setId("type-1");
		type1.setName("name-type1");
		type1.setDescription("description1");
		type1.setActive(true);
		type1.setDuration(10);
		type1.setCreatedBy("system");
		type1.setCreatedDate(Instant.now());
		types.add(type1);

		Type type2 = new Type();
		type2.setId("type-2");
		type2.setName("name-type2");
		type2.setDescription("description2");
		type2.setActive(true);
		type2.setDuration(10);
		type2.setCreatedBy("system");
		type2.setCreatedDate(Instant.now());
		types.add(type2);

		Type type3 = new Type();
		type3.setId("type-3");
		type3.setName("name-type3");
		type3.setDescription("description3");
		type3.setActive(true);
		type3.setDuration(10);
		type3.setCreatedBy("system");
		type3.setCreatedDate(Instant.now());
		types.add(type3);

		return types;
	}

	private Set<Category> getCategories() {
		Set<Category> categories = new HashSet<>();
		Category type1 = new Category();
		type1.setId("category-1");
		type1.setName("name-category1");
		type1.setDescription("description1");
		type1.setActive(true);
		type1.setCreatedBy("system");
		type1.setCreatedDate(Instant.now());
		categories.add(type1);

		Category category2 = new Category();
		category2.setId("category-2");
		category2.setName("name-category2");
		category2.setDescription("description2");
		category2.setActive(true);
		category2.setCreatedBy("system");
		category2.setCreatedDate(Instant.now());
		categories.add(category2);

		Category category3 = new Category();
		category3.setId("category-3");
		category3.setName("name-category3");
		category3.setDescription("description3");
		category3.setActive(true);
		category3.setCreatedBy("system");
		category3.setCreatedDate(Instant.now());
		categories.add(category3);

		return categories;
	}

}
