
delete from customer where crb_cust_id in (5999,5998);
delete from crb_zero_store where crb_cust_id = 5999;

INSERT INTO customer (crb_cust_id, address,comments,email,name, password,phone, role) VALUES (5999,'NJ' ,'NJ','prasad.kurella@gmail.com', 'srivalli', '$2a$10$3zHzb.Npv1hfZbLEU5qsdOJKhtL.ZSM3lP5kj4OwNu9DQFiam.ryy','6462061374','ROLE_USER');
INSERT INTO customer (crb_cust_id, address,comments,email,name, password,phone, role) VALUES (5998,'NJ' ,'NJ','kvrprasadmca@gmail.com', 'srikanthi', '$2a$10$51vFedzLZp5Rsg5vYZOsAOBkNMA9soKskX7Ye343NC2sGjWCLse6y','6462061374','ROLE_USER');

insert into crb_zero_store(crb_cust_id,comments,store_lat,store_lon,store_name,trip_ping,trip_range) values(5999,'Costco','40.590536670','-74.285190330','Costco Edision',60,100);