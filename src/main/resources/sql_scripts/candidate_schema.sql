-- Table: candidaterequest

-- DROP TABLE candidaterequest;

CREATE TABLE candidaterequest
(
  candidate_id integer NOT NULL,
  email_address character varying(255),
  first_name character varying(255),
  interviewer character varying(255),
  last_name character varying(255),
  middle_name character varying(255),
  phone_number character varying(255),
  prefix character varying(255),
  role_applied character varying(255),
  technical_stack character varying(255),
  years_of_experience integer,
  recruiter_first_name character varying(100),
  recruiter_last_name character varying(100),
  recruiter_middle_name character varying(100),
  interviewer_first_name character varying(100),
  interviewer_last_name character varying(100),
  interviewer_middle_name character varying(100),
  candidate_skype_id character varying(100),
  cancel_interview_comment character varying(100),
  interview_schedule_date timestamp without time zone,
  interview_schedule_timezone character varying(3),
  CONSTRAINT candidaterequest_pkey PRIMARY KEY (candidate_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE candidaterequest
  OWNER TO postgres;
