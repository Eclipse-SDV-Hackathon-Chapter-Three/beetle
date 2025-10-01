
do
$$
    declare
        create_schema boolean;
    begin
        begin
            -- This check is necessary because Flyway is started with the baseline option and
            -- only executes migration scripts with version above baseline version.
            -- I didn't find a Flyway option to run or skip a script depending on whether a schema already exists, hence we check it ourselves.

            -- This query returns true if the table devices exists, even if it's empty, and is very fast even for big tables
            if
                exists(select count(*) from devices where false) then
                create_schema := false;
            end if;

        exception
            when undefined_table THEN create_schema := true;
        end;

        if
            create_schema then
            create sequence if not exists hibernate_sequence start 1 increment 1;
            create sequence if not exists devices_sequence start 1 increment 1;

            create table devices
            (
                id                       int8         not null primary key,
                device_id                 varchar(255),
                installation_status       varchar(255),
                installed_software        jsonb,
                created_at                timestamp,
                updated_at                timestamp,
                updated_by                varchar(255),
                prod_mode                 boolean      not null default false,
                country                   varchar(255)
            );
            create index idx_deviceId on devices (device_id);
        end if;
    end;
$$;
