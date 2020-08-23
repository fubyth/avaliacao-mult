--
-- PostgreSQL database dump
--

-- Dumped from database version 12.4
-- Dumped by pg_dump version 12.4

-- Started on 2020-08-23 14:19:01

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 16394)
-- Name: produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.produto (
    nome character varying(100),
    categoria bigint,
    valor double precision,
    id bigint NOT NULL
);


ALTER TABLE public.produto OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16397)
-- Name: produto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.produto ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.produto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


-- Completed on 2020-08-23 14:19:01

--
-- PostgreSQL database dump complete
--

