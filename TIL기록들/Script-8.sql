use dev;
insert into moti_catalog(moti_type,moti_level) values("basic","0");
insert into moti_catalog(moti_type,moti_level) values("basic","1");
insert into moti_catalog(moti_type,moti_level) values("basic","2");
insert into moti_catalog(moti_type,moti_level) values("basic","3");
insert into moti_catalog(moti_type,moti_level) values("basic","4");
insert into moti_catalog(moti_type,moti_level) values("export","0");
insert into moti_catalog(moti_type,moti_level) values("test","0");
insert into moti_catalog(moti_type,moti_level) values("new","0");
select * from moti_catalog mc ;

insert into moti_img (moti_code, moti_catalog_no,moti_img)
values("default",1,"https://motimoti-bucket.s3.ap-northeast-2.amazonaws.com/basic/0_+v1/basic_0_default.gif");
insert into moti_img (moti_code, moti_catalog_no,moti_img)
values("shower",1,"https://motimoti-bucket.s3.ap-northeast-2.amazonaws.com/basic/0_+v1/basic_0_showert.gif");
insert into moti_img (moti_code, moti_catalog_no,moti_img)
values("hungry",1,"https://motimoti-bucket.s3.ap-northeast-2.amazonaws.com/basic/0_+v1/basic_0_hungry.gif");
insert into moti_img (moti_code, moti_catalog_no,moti_img)
values("eatting",1,"https://motimoti-bucket.s3.ap-northeast-2.amazonaws.com/basic/0_+v1/basic_0_eatting.gif");
insert into moti_img (moti_code, moti_catalog_no,moti_img)
values("playing",1,"https://motimoti-bucket.s3.ap-northeast-2.amazonaws.com/basic/0_+v1/basic_0_playing.gif");
select * from moti_img mi ;

update from user_moti_status set 
update from user_invetory set item_count =item_count -1 if( 
select item_count from user_inventory ug where and item_catalog_no=1 >0 ) where user_no; 

-- 1번째 쿼리
select user_no from user_moti_status ums where DATE(ums.latest_feed_date) <= (NOW() - interval 2 day);
-- 2번째 쿼리

-- 1 & 2 번 합치기
select ui.user_no from user_inventory ui,
		(
			select user_no 
			from user_moti_status ums 
			where DATE(ums.latest_feed_date) <= (NOW() - interval 2 day)
		) as dead
		where ui.user_no = dead.user_no and ui.item_catalog_no =2 and ui.item_count >=0  



-- 1& 2& 3번 합치기 성공...
update user_inventory as ui_2,
	(
		select ui.user_no from user_inventory ui,
		(
			select user_no 
			from user_moti_status ums 
			where DATE(ums.latest_feed_date) <= (NOW() - interval 2 day)
		) as dead
		where ui.user_no = dead.user_no and ui.item_catalog_no =2 and ui.item_count >0  

	)as d
set ui_2.item_count = ui_2.item_count -1
where ui_2.user_no = d.user_no and ui_2.item_catalog_no=2 ;

-- 1 & 2 & 4번 합치기
update user_moti_status as ums_2,
	(
		select ui.user_no from user_inventory ui,
		(
			select user_no 
			from user_moti_status ums 
			where DATE(ums.latest_feed_date) <= (NOW() - interval 2 day)
		) as dead
		where ui.user_no = dead.user_no and ui.item_catalog_no =2 and ui.item_count >=0  

	)as d
set	ums_2.latest_feed_time = "00:00:00",ums_2.latest_feed_date = date_format(now(),'%Y-%m-%d')
where ums_2.user_no = d.user_no;

select * from user_inventory ui where user_no =1;
update  user_inventory set item_count =1 where user_no =1 and item_catalog_no =2;
select * from user_moti_status ums ;


-- set ums_2.latest_feed_date = date_format(now(),'%Y-%m-%d'),

BEGIN
        insert into dead_moti(moti_birth,moti_death,moti_gender,moti_name,user_no,moti_catalog_no)
        select umi.moti_birth,date_format(now(),'%Y%m%d')as moti_death,umi.moti_gender ,umi.moti_name ,umi.user_no,umi.moti_catalog_no 
        from dev.user_moti_info umi , dev.user_moti_status ums 
        where DATE(ums.latest_feed_date) <=(NOW() -interval 2 day);

       delete umi, ums from dev.user_moti_info  umi join dev.user_moti_status ums
       on umi.user_no  = ums.user_no 
       where DATE(ums.latest_feed_date) <=(NOW() -interval 2 day);

      update  dev.user_moti_status  set live_days = live_days+1, survival_days = survival_days+1 where live_days is not null;

     insert into ranking(moti_name,live_days,moti_img,closeness,user_name)
    select umi.moti_name  ,ums.live_days,mi.moti_img,ums.closeness,user.name
    from dev.user_moti_info as umi, dev.user_moti_status as ums ,dev.moti_img mi, user 
    where umi.user_no = ums.user_no and umi.moti_catalog_no=mi.moti_catalog_no 
        and mi.moti_code ="default" and user.user_no =umi.user_no 
    order by ums.live_days, ums.closeness ,ums.survival_days , umi.moti_name,user.name ;
   
   end;


