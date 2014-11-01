#!/bin/bash
DDL="CREATE TABLE data (
	temperature number not null,
	humidity number not null,
	stamp date default (datetime(CURRENT_TIMESTAMP, 'localtime')));"
sqlite3 $1.db "$DDL"
