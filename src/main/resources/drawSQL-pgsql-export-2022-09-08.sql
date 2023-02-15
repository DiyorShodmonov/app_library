CREATE TABLE "books"(
    "id" SERIAL NOT NULL,
    "title" VARCHAR(255) NOT NULL,
    "isbn" varchar NOT NULL,
    "total_count" INTEGER NOT NULL,
    "description" text,
    "language_id" INTEGER NOT NULL
);
ALTER TABLE
    "books" ADD PRIMARY KEY("id");
CREATE TABLE "authors"(
    "id" SERIAL NOT NULL,
    "fullName" VARCHAR(255) NOT NULL,
    "biography" VARCHAR(255)
);
ALTER TABLE
    "authors" ADD PRIMARY KEY("id");
CREATE TABLE "books_authors"(
    "book_id" INTEGER NOT NULL,
    "author_id" INTEGER NOT NULL
);
CREATE TABLE "categories"(
    "id" SERIAL NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "description" TEXT
);
ALTER TABLE
    "categories" ADD PRIMARY KEY("id");
CREATE TABLE "books_categories"(
    "book_id" INTEGER NOT NULL,
    "category_id" INTEGER NOT NULL
);
CREATE TABLE "languages"(
    "id" SERIAL NOT NULL,
    "lang" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "languages" ADD PRIMARY KEY("id");
CREATE TABLE "users"(
    "id" SERIAL NOT NULL,
    "full_name" VARCHAR(255) NOT NULL,
    "phone_number" VARCHAR(255) NOT NULL,
    "is_admin" BOOLEAN NOT NULL default false,
    "password" VARCHAR(255) NOT NULL default 123
);
ALTER TABLE
    "users" ADD PRIMARY KEY("id");
CREATE TABLE "records"(
    "id" SERIAL NOT NULL,
    "is_returned" BOOLEAN NOT NULL default false,
    "dateTime" timestamp NOT NULL,
    "user_id" INTEGER NOT NULL
);
ALTER TABLE
    "records" ADD PRIMARY KEY("id");
CREATE TABLE "records_books"(
    "record_id" INTEGER NOT NULL,
    "book_id" INTEGER NOT NULL
);
ALTER TABLE
    "books_authors" ADD CONSTRAINT "books_authors_book_id_foreign" FOREIGN KEY("book_id") REFERENCES "books"("id");
ALTER TABLE
    "books_authors" ADD CONSTRAINT "books_authors_author_id_foreign" FOREIGN KEY("author_id") REFERENCES "authors"("id");
ALTER TABLE
    "books_categories" ADD CONSTRAINT "books_categories_category_id_foreign" FOREIGN KEY("category_id") REFERENCES "categories"("id");
ALTER TABLE
    "books_categories" ADD CONSTRAINT "books_categories_book_id_foreign" FOREIGN KEY("book_id") REFERENCES "books"("id");
ALTER TABLE
    "records_books" ADD CONSTRAINT "records_books_book_id_foreign" FOREIGN KEY("book_id") REFERENCES "books"("id");
ALTER TABLE
    "records_books" ADD CONSTRAINT "records_books_record_id_foreign" FOREIGN KEY("record_id") REFERENCES "records"("id");
ALTER TABLE
    "records" ADD CONSTRAINT "records_user_id_foreign" FOREIGN KEY("user_id") REFERENCES "users"("id");
ALTER TABLE
    "books" ADD CONSTRAINT "books_language_id_foreign" FOREIGN KEY("language_id") REFERENCES "languages"("id");