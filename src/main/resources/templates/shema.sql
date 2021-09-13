SELECT
  * FROM HR.up_subscriptions;

CREATE SEQUENCE sub_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
CREATE OR REPLACE TRIGGER subs_on_insert
  BEFORE INSERT ON HR.up_subscriptions
  FOR EACH ROW
BEGIN :new.subscription_id:=sub_seq.nextval; 
END;

drop TABLE HR.up_subscriptions;
drop SEQUENCE sub_seq;
drop TRIGGER subs_on_insert;