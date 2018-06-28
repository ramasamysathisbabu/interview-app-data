-- Table: file_upload_meta_data

-- DROP TABLE file_upload_meta_data;

CREATE TABLE file_upload_meta_data
(
  id bigint NOT NULL,
  content_size bigint NOT NULL,
  content_type character varying(255),
  name character varying(255),
  file_content bytea,
  CONSTRAINT file_upload_meta_data_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE file_upload_meta_data
  OWNER TO postgres;
