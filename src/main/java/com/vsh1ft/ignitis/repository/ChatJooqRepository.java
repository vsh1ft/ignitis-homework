package com.vsh1ft.ignitis.repository;

import com.vsh1ft.ignitis.type.Message;
import com.vsh1ft.ignitis.type.repository.ChatRepository;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import static com.vsh1ft.ignitis.model.tables.Message.MESSAGE;
import static com.vsh1ft.ignitis.model.tables.Person.PERSON;
import static org.jooq.impl.DSL.*;

import java.util.List;


@Repository
public class ChatJooqRepository implements ChatRepository {

    private final DSLContext dslContext;

    public ChatJooqRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public void saveMessage(Message message) {
        var record = dslContext.newRecord(MESSAGE, message);
        record.setPersonId(message.getPerson().getId());

        record.store();
    }

    @Override
    public List<Message> findMessagesOrderedByLatest() {
        return dslContext.
                select(MESSAGE.ID,
                        MESSAGE.CONTENT,
                        MESSAGE.TIME_RECEIVED,
                        field(select(row(PERSON.ID, PERSON.IS_ADMIN, PERSON.IS_ACTIVE,
                                when(PERSON.IS_ACTIVE.eq(true), "Anonymous").otherwise(PERSON.NAME)
                        )).from(PERSON).where(MESSAGE.PERSON_ID.eq(PERSON.ID)))
                )
                .from(MESSAGE)
                .orderBy(MESSAGE.TIME_RECEIVED.desc()).fetchInto(Message.class);
    }

}

