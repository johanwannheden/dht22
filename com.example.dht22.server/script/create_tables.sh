#!/bin/bash
DDL='CREATE TABLE data (
	id integer primary key autoincrement,
	temperature number not null,
	humidity number not null,
	timestamp timestamp default (datetime(current_timestamp, "localtime"));'
sqlite3 ~/dht22.db "$DDL"
