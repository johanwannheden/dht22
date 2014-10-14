#!/bin/bash
DDL="CREATE TABLE data (
	id integer primary key autoincrement,
	temperature number not null,
	humidity number not null,
	stamp default (datetime(CURRENT_TIMESTAMP, 'localtime')));"
sqlite3 ~/dht22.db "$DDL"
