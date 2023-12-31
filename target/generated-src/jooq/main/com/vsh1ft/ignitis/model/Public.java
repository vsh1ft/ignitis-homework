/*
 * This file is generated by jOOQ.
 */
package com.vsh1ft.ignitis.model;


import com.vsh1ft.ignitis.model.tables.Databasechangelog;
import com.vsh1ft.ignitis.model.tables.Databasechangeloglock;
import com.vsh1ft.ignitis.model.tables.Message;
import com.vsh1ft.ignitis.model.tables.Person;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>PUBLIC</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>PUBLIC.DATABASECHANGELOG</code>.
     */
    public final Databasechangelog DATABASECHANGELOG = Databasechangelog.DATABASECHANGELOG;

    /**
     * The table <code>PUBLIC.DATABASECHANGELOGLOCK</code>.
     */
    public final Databasechangeloglock DATABASECHANGELOGLOCK = Databasechangeloglock.DATABASECHANGELOGLOCK;

    /**
     * The table <code>PUBLIC.MESSAGE</code>.
     */
    public final Message MESSAGE = Message.MESSAGE;

    /**
     * The table <code>PUBLIC.PERSON</code>.
     */
    public final Person PERSON = Person.PERSON;

    /**
     * No further instances allowed
     */
    private Public() {
        super("PUBLIC", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Databasechangelog.DATABASECHANGELOG,
            Databasechangeloglock.DATABASECHANGELOGLOCK,
            Message.MESSAGE,
            Person.PERSON
        );
    }
}
