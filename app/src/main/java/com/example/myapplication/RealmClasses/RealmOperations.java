package com.example.myapplication.RealmClasses;

import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmResults;

public class RealmOperations {
    public void insertUserDetails(UsersRealm usersRealm) {
        try (Realm realm = Realm.getDefaultInstance()) {

            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm _realm) {
                    _realm.insert(usersRealm);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<UsersRealm> getUserList() {
        List<UsersRealm> usersRealmList = null;
        try (Realm realm = Realm.getDefaultInstance()) {
            RealmResults<UsersRealm> _usersRealmResults = realm.where(UsersRealm.class).findAll();
            if (_usersRealmResults != null) {
                usersRealmList = realm.copyFromRealm(_usersRealmResults);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return usersRealmList;
    }

    public void deleteuserByUUID(String userUUID) {

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    UsersRealm usersRealm1 = realm.where(UsersRealm.class).equalTo("userUUID", userUUID, Case.INSENSITIVE).findFirst();
                    if (usersRealm1 != null) {
                        usersRealm1.deleteFromRealm();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public UsersRealm getUserDetailsByUUID(String userUUId) {
        UsersRealm usersRealm = null;
        try (Realm realm = Realm.getDefaultInstance()) {
            UsersRealm usersRealm1 = realm.where(UsersRealm.class).equalTo("userUUID", userUUId, Case.INSENSITIVE).findFirst();
            if (usersRealm1 != null) {
                usersRealm = realm.copyFromRealm(usersRealm1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersRealm;
    }


    /* update the data in realm*/
    public void updatedetails(UsersRealm usersRealm, String UUid) {
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {

                    UsersRealm usersRealm1 = realm.where(UsersRealm.class).equalTo("userUUID", UUid, Case.INSENSITIVE).findFirst();
                    if (usersRealm1 != null) {
                        usersRealm1.setUserName(usersRealm.getUserName());
                        usersRealm1.setUserMobileNumber(usersRealm.getUserMobileNumber());
                        usersRealm1.setUserEmailId(usersRealm.getUserEmailId());
                    }
                    realm.copyToRealmOrUpdate(usersRealm1
                    );
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public List<ProductsRealm> getProductList() {
        List<ProductsRealm> productsRealmList = null;
        try (Realm realm = Realm.getDefaultInstance()) {
            RealmResults<ProductsRealm> _productRealmList = realm.where(ProductsRealm.class).findAll();
            if (_productRealmList != null) {
                productsRealmList = realm.copyFromRealm(_productRealmList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productsRealmList;
    }


    public void insertProductDetails(ProductsRealm productsRealm) {
        try (Realm realm = Realm.getDefaultInstance()) {

            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm _realm) {
                    _realm.insert(productsRealm);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}


