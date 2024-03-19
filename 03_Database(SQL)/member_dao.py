

def insert_member(cursor, conn, name, email, tall, birthday):
    sql = "insert into member (name, email, tall, birthday, create_at)\
                       values (%s, %s, %s, %s, now())"
    return cursor.execute(sql, (name, email, tall, birthday))

def update_member(cursor, id, name, email, tall, birthday):
    sql = "update member set name=%s, email=%s, tall=%s, birthday=%s where id=%s"
    return cursor.execute(sql, (name, email, tall, birthday, id))

def delete_member(cursor, id):
    sql = "delete from member where id=%s"
    return cursor.execute(sql, id)

def select_members(cursor):
    sql = "select * from member"
    cursor.execute(sql)
    return cursor.fetchall()

def select_member_by_id(cursor, id):
    sql = "select * from member where id = %s"
    cursor.execute(sql, id)
    return cursor.fetchone()
