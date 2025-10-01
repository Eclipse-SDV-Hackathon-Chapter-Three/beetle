
do
$$
    declare
        create_schema boolean;
    begin
        begin
            -- This check is necessary because Flyway is started with the baseline option and
            -- only executes migration scripts with version above baseline version.
            -- I didn't find a Flyway option to run or skip a script depending on whether a schema already exists, hence we check it ourselves.

            -- This query returns true if the table logs_requests exists, even if it's empty, and is very fast even for big tables
            if
                exists(select count(*) from product_software where false) then
                create_schema := false;
            end if;

        exception
            when undefined_table THEN create_schema := true;
        end;

        if
            create_schema then
            create sequence if not exists hibernate_sequence start 1 increment 1;
            create sequence if not exists product_software_sequence start 1 increment 1;

            create table product_software
            (
                id                       int8         not null primary key,
                swAssy                   varchar(255) not null,
                swAssyVersion            varchar(255) not null,
                diagnosticGeneration     varchar(255) not null,
                diagnosticFamily         varchar(255) not null,
                softwareId               varchar(255),
                ivd                      jsonb,
                createdAt                timestamp,
                updatedAt                timestamp,
                updatedBy                varchar(255)
            );
            create index idx_softwareId on product_software (softwareId);
            create index idx_swAssy_swAssyVersion on product_software (swAssy, swAssyVersion);

            create sequence if not exists hibernate_sequence start 1 increment 1;
            create sequence if not exists software_installation_sequence start 1 increment 1;

            create table software_installation
            (
                id                 int8         not null primary key,
                vin                varchar(255) not null,
                serialNumber       varchar(255) not null,
                softwareId          varchar(255) not null,
                createdAt          timestamp,
                updatedAt          timestamp,
                reportedIvd        jsonb,
                swAssy             varchar(255),
                swAssyVersion      varchar(255),
                cplNo              varchar(255),
                syncStatus         varchar(255),
                piiPayload         jsonb
            );
            create index idx_vin_syncStatus on software_installation(vin, syncStatus);
            create index idx_vin on software_installation(vin);

        end if;
    end;
$$;
