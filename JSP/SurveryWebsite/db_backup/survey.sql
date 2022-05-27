PGDMP         
                z            survey    12.2    12.2      )           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            *           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            +           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ,           1262    24670    survey    DATABASE     �   CREATE DATABASE survey WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Punjabi_India.utf8' LC_CTYPE = 'Punjabi_India.utf8';
    DROP DATABASE survey;
                postgres    false            �            1259    24705    answers    TABLE     T   CREATE TABLE public.answers (
    id integer NOT NULL,
    ans_csv text NOT NULL
);
    DROP TABLE public.answers;
       public         heap    postgres    false            �            1259    24703    answers_id_seq    SEQUENCE     �   CREATE SEQUENCE public.answers_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.answers_id_seq;
       public          postgres    false    207            -           0    0    answers_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.answers_id_seq OWNED BY public.answers.id;
          public          postgres    false    206            �            1259    24716    collected_answers    TABLE     �   CREATE TABLE public.collected_answers (
    id integer NOT NULL,
    question_id integer NOT NULL,
    user_id integer NOT NULL,
    answer text NOT NULL
);
 %   DROP TABLE public.collected_answers;
       public         heap    postgres    false            �            1259    24714    collected_answers_id_seq    SEQUENCE     �   CREATE SEQUENCE public.collected_answers_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.collected_answers_id_seq;
       public          postgres    false    209            .           0    0    collected_answers_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.collected_answers_id_seq OWNED BY public.collected_answers.id;
          public          postgres    false    208            �            1259    24694 	   questions    TABLE     �   CREATE TABLE public.questions (
    id integer NOT NULL,
    question text NOT NULL,
    answer_id integer NOT NULL,
    status integer NOT NULL
);
    DROP TABLE public.questions;
       public         heap    postgres    false            �            1259    24692    questions_id_seq    SEQUENCE     �   CREATE SEQUENCE public.questions_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.questions_id_seq;
       public          postgres    false    205            /           0    0    questions_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.questions_id_seq OWNED BY public.questions.id;
          public          postgres    false    204            �            1259    24683    users    TABLE     �   CREATE TABLE public.users (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    created_at text NOT NULL,
    type character varying(6)
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    24681    users_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public          postgres    false    203            0           0    0    users_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
          public          postgres    false    202            �
           2604    24708 
   answers id    DEFAULT     h   ALTER TABLE ONLY public.answers ALTER COLUMN id SET DEFAULT nextval('public.answers_id_seq'::regclass);
 9   ALTER TABLE public.answers ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    206    207    207            �
           2604    24719    collected_answers id    DEFAULT     |   ALTER TABLE ONLY public.collected_answers ALTER COLUMN id SET DEFAULT nextval('public.collected_answers_id_seq'::regclass);
 C   ALTER TABLE public.collected_answers ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    208    209    209            �
           2604    24697    questions id    DEFAULT     l   ALTER TABLE ONLY public.questions ALTER COLUMN id SET DEFAULT nextval('public.questions_id_seq'::regclass);
 ;   ALTER TABLE public.questions ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    204    205            �
           2604    24686    users id    DEFAULT     d   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202    203            $          0    24705    answers 
   TABLE DATA           .   COPY public.answers (id, ans_csv) FROM stdin;
    public          postgres    false    207   s!       &          0    24716    collected_answers 
   TABLE DATA           M   COPY public.collected_answers (id, question_id, user_id, answer) FROM stdin;
    public          postgres    false    209   �!       "          0    24694 	   questions 
   TABLE DATA           D   COPY public.questions (id, question, answer_id, status) FROM stdin;
    public          postgres    false    205   �!                  0    24683    users 
   TABLE DATA           L   COPY public.users (id, name, email, password, created_at, type) FROM stdin;
    public          postgres    false    203   �!       1           0    0    answers_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.answers_id_seq', 1, false);
          public          postgres    false    206            2           0    0    collected_answers_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.collected_answers_id_seq', 1, false);
          public          postgres    false    208            3           0    0    questions_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.questions_id_seq', 1, false);
          public          postgres    false    204            4           0    0    users_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.users_id_seq', 5, true);
          public          postgres    false    202            �
           2606    24713    answers answers_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.answers
    ADD CONSTRAINT answers_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.answers DROP CONSTRAINT answers_pkey;
       public            postgres    false    207            �
           2606    24724 (   collected_answers collected_answers_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.collected_answers
    ADD CONSTRAINT collected_answers_pkey PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.collected_answers DROP CONSTRAINT collected_answers_pkey;
       public            postgres    false    209            �
           2606    24702    questions questions_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.questions
    ADD CONSTRAINT questions_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.questions DROP CONSTRAINT questions_pkey;
       public            postgres    false    205            �
           2606    24691    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    203            $      x������ � �      &      x������ � �      "      x������ � �          �   x����
�0E痯��$/m����Mp�a�4�$FЯ�6��۹���6pL��1���Ǽ��[ ?��%@���k�P��DW����"��"S`��g~X�h�>��t�ͱ%�*Z�veg-����	h����x�h�4�)O�5c�[(>O     