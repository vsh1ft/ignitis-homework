package com.vsh1ft.ignitis.repository;

import com.vsh1ft.ignitis.type.Person;
import com.vsh1ft.ignitis.type.repository.UserRepository;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

import static com.vsh1ft.ignitis.model.tables.Message.MESSAGE;
import static com.vsh1ft.ignitis.model.tables.Person.PERSON;
import static org.jooq.impl.DSL.*;

@Repository
public class UserJooqRepository implements UserRepository {

    private final DSLContext dslContext;

    public UserJooqRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public void saveUser(Person person) {
        dslContext.newRecord(PERSON, person).store();
    }

    @Override
    public Person findUser(String userId) {
        return dslContext.select(PERSON).from(PERSON).where(PERSON.ID.eq(userId)).fetchOneInto(Person.class);
    }

    @Override
    public boolean doesNameExist(String name) {
        var personRecord = dslContext.select().from(PERSON).where(PERSON.NAME.eq(name)).fetch();

        return personRecord.size() > 0;
    }

    @Override
    public void deleteUser(String userId) {
        dslContext.update(PERSON).set(PERSON.IS_ACTIVE, false).where(PERSON.ID.eq(userId)).execute();
    }

    @Override
    public int countMessagesByUserId(String userId) {
        return dslContext.fetchCount(select().from(MESSAGE).where(MESSAGE.PERSON_ID.eq(userId)));
    }

    @Override
    public LocalDateTime findFirstMessageByUserId(String userId) {
        return dslContext
                .select(min(MESSAGE.TIME_RECEIVED))
                .from(MESSAGE)
                .where(MESSAGE.PERSON_ID.eq(userId))
                .fetchOneInto(LocalDateTime.class);
    }

    @Override
    public LocalDateTime findLastMessageByUserId(String userId) {
        return dslContext
                .select(max(MESSAGE.TIME_RECEIVED))
                .from(MESSAGE)
                .where(MESSAGE.PERSON_ID.eq(userId))
                .fetchOneInto(LocalDateTime.class);
    }

    @Override
    public Double findAverageMessageLength(String userId) {
        return dslContext
                .select(coalesce(avg(length(MESSAGE.CONTENT)), 0))
                .from(MESSAGE)
                .where(MESSAGE.PERSON_ID.eq(userId))
                .fetchOneInto(Double.class);
    }

    @Override
    public String findLastMessageTextByUserId(String userId) {
        return dslContext
                .select(MESSAGE.CONTENT)
                .from(MESSAGE)
                .where(MESSAGE.TIME_RECEIVED.eq(select(max(MESSAGE.TIME_RECEIVED))
                        .from(MESSAGE)
                        .where(MESSAGE.PERSON_ID.eq(userId)))
                )
                .fetchOneInto(String.class);
    }
}

