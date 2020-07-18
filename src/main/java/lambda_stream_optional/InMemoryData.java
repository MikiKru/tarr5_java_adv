package lambda_stream_optional;

import oop.model.User;
import oop.model.enums.Gender;
import oop.model.enums.Role;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public interface InMemoryData {
    List<User> users = new ArrayList<>(
            Arrays.asList(
                    new User(1, "Adam", "Kowalski", "ak@ak.pl", "ak", "123-123-123", Gender.MAN,
                            new HashSet<>(Arrays.asList(Role.ROLE_USER, Role.ROLE_ADMIN)),
                            LocalDateTime.of(2010, 10, 10, 10, 10, 10),
                            true,
                            false),
                    new User(2, "Jan", "Nowak", "jn@jn.pl", "jn", "333-123-123", Gender.MAN,
                            new HashSet<>(Arrays.asList(Role.ROLE_USER)),
                            LocalDateTime.of(2012, 11, 1, 11, 10, 10),
                            true,
                            false),
                    new User(3, "Anna", "Lis", "al@al.pl", "al", "444-231-823", Gender.WOMAN,
                            new HashSet<>(Arrays.asList(Role.ROLE_USER, Role.ROLE_VIEWER)),
                            LocalDateTime.of(2020, 1, 5, 13, 10, 10),
                            false,
                            false),
                    new User(5, "Hanna", "Lis", "hl@hl.pl", "hl", "114-231-823", Gender.WOMAN,
                            new HashSet<>(Arrays.asList(Role.ROLE_VIEWER)),
                            LocalDateTime.of(2020, 5, 5, 13, 10, 10),
                            false,
                            true),
                    new User(6,
                            "Test",
                            "Test",
                            "t@t.pl",
                            "t",
                            "123-321-123",
                            Gender.MAN,
                            new HashSet<>(Arrays.asList(Role.ROLE_USER)),
                            LocalDateTime.now(),
                            true,
                            false)
            )
    );
}
